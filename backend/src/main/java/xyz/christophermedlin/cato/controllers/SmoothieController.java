package xyz.christophermedlin.cato.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.christophermedlin.cato.entities.Smoothie;
import xyz.christophermedlin.cato.repositories.SmoothieRepository;

import java.util.List;

@RestController
public class SmoothieController {

    @Autowired
    SmoothieRepository repo;

    @GetMapping("/smoothies")
    public List<Smoothie> index() {
        return this.repo.findAll();
    }

    @GetMapping("/smoothies/{id}")
    public Smoothie byId(@PathVariable(value="id") Long id) {
        return repo.findById(id).get();
    }
}
