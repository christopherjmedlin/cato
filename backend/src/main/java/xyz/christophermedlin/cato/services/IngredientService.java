package xyz.christophermedlin.cato.services;

import xyz.christophermedlin.cato.entities.Ingredient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IngredientService {
    public Page<Ingredient> findByNameContains(String contains, Pageable page);
    public Page<Ingredient> findAll(Pageable page);
}
