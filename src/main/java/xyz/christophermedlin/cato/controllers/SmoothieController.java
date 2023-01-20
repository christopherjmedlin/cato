package xyz.christophermedlin.cato.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.christophermedlin.cato.repositories.SmoothieRepository;

@RestController
public class SmoothieController {

    @Autowired
    SmoothieRepository repo;

    @GetMapping("/smoothies")
    public String index() {
        return "Hello world";
    }
}
