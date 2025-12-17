package org.carlosacademic.springbootandspringmvc.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The same as the old controller but using the new annotations
 * The rest controller is an annotation that adds response body to the methods in the class
 * for avoiding boilerplate code
 */
@RestController
public class NewController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }
}
