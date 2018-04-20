package com.pshenmic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Dummy controller for html5 mode in angular2
 */

@Controller
public class DummyController {

    @RequestMapping({"/product/*", "products", "product"})
    public String index() {
        return "forward:/";
    }
}
