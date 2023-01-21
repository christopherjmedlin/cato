package xyz.christophermedlin.cato.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.christophermedlin.cato.entities.Ingredient;
import xyz.christophermedlin.cato.repositories.IngredientRepository;
import xyz.christophermedlin.cato.services.IngredientService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class IngredientController {

    @Autowired
    IngredientService service;

    @GetMapping("/ingredients")
    public List<Ingredient> index(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) Optional<Integer> page) {
        if (name == null) {
            return service.findAll(PageRequest.of(page.orElse(0), 10));
        }
        return service.findByNameContains(
                name,
                PageRequest.of(page.orElse(0), 10)
        );
    }
}
