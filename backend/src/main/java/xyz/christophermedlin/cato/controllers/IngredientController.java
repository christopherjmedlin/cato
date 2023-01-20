package xyz.christophermedlin.cato.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.christophermedlin.cato.entities.Ingredient;
import xyz.christophermedlin.cato.repositories.IngredientRepository;

import java.util.List;

@RestController
public class IngredientController {

    @Autowired
    IngredientRepository repo;

    @GetMapping("/ingredients")
    public List<Ingredient> index(@RequestParam(required = false) String name) {
        if (name == null) {
            return repo.findAll();
        }
        return repo.findByNameContains(name);
    }
}
