package com.pshenmic.api.rest;


import com.pshenmic.model.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/api")
public interface AdminAPI {


    /**
     * Allowed roles : [ROLE_ADMIN]
     * <p>
     * Adds product to database
     * 200 - OK
     *
     * @param productDTO {ProductDTO}
     */
    @Secured("ADMIN")
    @RequestMapping(value = "/admin/product", method = RequestMethod.PUT)
    ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO);

    /**
     * Allowed roles : [ROLE_ADMIN]
     * <p>
     * Deletes product from database
     * <p>
     * 200 - OK
     * 404 - Product not found by the given id
     *
     * @param id {Long}
     */
    @Secured("ADMIN")
    @RequestMapping(value = "/admin/product/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Long id);

}
