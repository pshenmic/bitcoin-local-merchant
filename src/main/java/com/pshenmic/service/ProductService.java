package com.pshenmic.service;

import com.pshenmic.domain.Product;
import com.pshenmic.model.dto.ProductDTO;
import com.pshenmic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.getOne(id);
    }

    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return productRepository.save(product);
    }

    //todo edit method

    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }


}
