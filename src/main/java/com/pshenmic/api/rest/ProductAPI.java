package com.pshenmic.api.rest;


import com.pshenmic.exception.OperationPriceExtractingException;
import com.pshenmic.exception.UnknownCurrencyException;
import com.pshenmic.model.dto.OperationPriceDTO;
import com.pshenmic.model.dto.OrderDTO;
import com.pshenmic.model.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@RequestMapping(value = "/api")
public interface ProductAPI {


    /**
     * Allowed roles : [ROLE_ANONYMOUS, ROLE_ADMIN]
     * <p>
     * Returns list of all products
     * <p>
     * 200 : {List<ProductDTO>} list af all products
     *
     * @return {AuthCheckDTO}
     */
    @RequestMapping(value = "/product/getAll", method = RequestMethod.GET)
    ResponseEntity<List<ProductDTO>> getAllProducts();


    /**
     * Allowed roles : [ROLE_ANONYMOUS, ROLE_ADMIN]
     * <p>
     * Returns {ProductDTO} by the given id
     * <p>
     * 200 : {ProductDTO} product dto
     * 404 : Product not found by the given id
     *
     * @return {AuthCheckDTO}
     */
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    ResponseEntity<ProductDTO> getProductById(@PathVariable Long id);


    /**
     * Allowed roles : [ROLE_ANONYMOUS, ROLE_ADMIN]
     * <p>
     * Returns {OperationPrice} of the product by id
     * <p>
     * 200 : operation price {OperationPrice}
     *
     * @return {OperationPrice}
     */
    @RequestMapping(value = "/product/{id}/price", method = RequestMethod.GET)
    ResponseEntity<OperationPriceDTO> getOperationPriceByProductId(@PathVariable Long id) throws OperationPriceExtractingException, UnknownCurrencyException;

    /**
     * Allowed roles : [ROLE_ANONYMOUS, ROLE_USER, ROLE_ADMIN]
     * <p>
     * Makes order and returns {OrderDTO}
     * <p>
     * 200 : {OrderDTO} dto of created order
     *
     * @return {AuthCheckDTO}
     */
    @RequestMapping(value = "/product/{id}/order", method = RequestMethod.GET)
    ResponseEntity<OrderDTO> makeOrderByProductId(@PathVariable Long id);


}
