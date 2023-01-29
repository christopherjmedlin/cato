package xyz.christophermedlin.cato.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.christophermedlin.cato.entities.Ingredient;
import xyz.christophermedlin.cato.services.IngredientService;

@CrossOrigin
@RestController
public class IngredientController {

    @Autowired
    IngredientService service;

    @GetMapping("/ingredients")
    public List<Ingredient> index(@RequestParam(required = false) String name,
                                  @PageableDefault(size=10) Pageable page) {
        if (name == null) {
            return service.findAll(page).toList();
        }
        return service.findByNameContains(
                name,
                page
        ).toList();
    }
}
