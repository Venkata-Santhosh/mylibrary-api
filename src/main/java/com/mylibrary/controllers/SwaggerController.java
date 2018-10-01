package com.mylibrary.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {

    @ApiOperation(value = "home", hidden = true)
    @RequestMapping(value = "/")
    public String docs() {
        return "redirect:swagger-ui.html";
    }
}