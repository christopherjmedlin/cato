package xyz.christophermedlin.cato.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.christophermedlin.cato.entities.Smoothie;
import xyz.christophermedlin.cato.services.SmoothieService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
public class SmoothieController {

    @Autowired
    SmoothieService service;

    @GetMapping("/smoothies")
    public List<Smoothie> index(@RequestParam(required = false) Optional<Integer> page,
                                @RequestParam(required = false) Set<Long> ingredientIds) {
        return this.service.findAll(
                PageRequest.of((int) page.orElseGet(() -> 0), 10),
                ingredientIds
        );
    }

    @GetMapping("/smoothies/{id}")
    public Smoothie byId(@PathVariable(value="id") Long id) {
        return service.findById(id);
    }
}
