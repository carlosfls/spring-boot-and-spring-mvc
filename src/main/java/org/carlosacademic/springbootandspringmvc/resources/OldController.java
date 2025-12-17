package org.carlosacademic.springbootandspringmvc.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ResponseBody is used to create the rest controller the old way for creating the rest controller
 */
@Controller
public class OldController {

    @GetMapping
    @ResponseBody
    public String helloWorld() {
        return "helloWorld";
    }
}
