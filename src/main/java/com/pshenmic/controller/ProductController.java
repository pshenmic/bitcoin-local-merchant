package com.pshenmic.controller;

import com.pshenmic.api.rest.ProductAPI;
import com.pshenmic.domain.Product;
import com.pshenmic.exception.OperationPriceExtractingException;
import com.pshenmic.model.OperationPrice;
import com.pshenmic.model.dto.OrderDTO;
import com.pshenmic.model.dto.ProductDTO;
import com.pshenmic.service.MappingService;
import com.pshenmic.service.PricesService;
import com.pshenmic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController implements ProductAPI {


    @Autowired
    private ProductService productService;

    @Autowired
    private MappingService mappingService;

    @Autowired
    private PricesService pricesService;

    @Override
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        return new ResponseEntity<>(mappingService.toDTO(products), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> getProductById(Long id) {
        Product product = productService.getProductById(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(mappingService.toDTO(product), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OperationPrice> getOperationPriceByProductId(Long id) throws OperationPriceExtractingException {
        Product product = productService.getProductById(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        OperationPrice operationPrice = pricesService.getPrice(product.getPrice());

        return new ResponseEntity<>(operationPrice, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<OrderDTO> makeOrderByProductId(Long id) {
        Product product = productService.getProductById(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //todo
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
