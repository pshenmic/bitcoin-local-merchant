package com.pshenmic.api.rest;


import com.pshenmic.model.dto.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/api")
public interface OrderAPI {

    /**
     * Allowed roles : [ROLE_ANONYMOUS, ROLE_ADMIN]
     * <p>
     * Gets order by its id
     * <p>
     * 200: OK
     * 404: Order not found by the given id
     *
     * @param id {Long}
     * @return {OrderDTO}
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    ResponseEntity<OrderDTO> getOrder(@PathVariable Long id);

}
