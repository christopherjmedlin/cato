package xyz.christophermedlin.cato.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.christophermedlin.cato.entities.Smoothie;
import xyz.christophermedlin.cato.repositories.SmoothieRepository;
import xyz.christophermedlin.cato.services.SmoothieService;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
public class SmoothieController {

    @Autowired
    SmoothieService service;

    @GetMapping("/smoothies")
    public List<Smoothie> index(@RequestParam(required = false) Optional<Integer> page) {
        return this.service.findAll(
                PageRequest.of((int) page.orElseGet(() -> 0), 10)
        );
    }

    @GetMapping("/smoothies/{id}")
    public Smoothie byId(@PathVariable(value="id") Long id) {
        return service.findById(id);
    }
}
