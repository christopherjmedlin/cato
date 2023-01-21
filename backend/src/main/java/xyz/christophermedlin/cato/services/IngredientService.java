package xyz.christophermedlin.cato.services;

import xyz.christophermedlin.cato.entities.Ingredient;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IngredientService {
    public List<Ingredient> findByNameContains(String contains, Pageable page);
    public List<Ingredient> findAll(Pageable page);
}
