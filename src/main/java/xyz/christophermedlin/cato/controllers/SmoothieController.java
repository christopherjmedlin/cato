package xyz.christophermedlin.cato.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmoothieController {

    @GetMapping("/")
    public String index() {
        return "Hello world";
    }
}
