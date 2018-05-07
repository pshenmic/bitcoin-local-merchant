package com.pshenmic.controller;

import com.pshenmic.api.rest.AdminAPI;
import com.pshenmic.domain.Product;
import com.pshenmic.model.dto.ProductDTO;
import com.pshenmic.service.MappingService;
import com.pshenmic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController implements AdminAPI {

    @Autowired
    private ProductService productService;

    @Autowired
    private MappingService mappingService;

    @Override
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        if (productDTO.getCurrency() == null || productDTO.getName() == null || productDTO.getPrice() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Product product = productService.createProduct(productDTO);

        return new ResponseEntity<>(mappingService.toDTO(product), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Product product = productService.getProductById(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}