package xyz.christophermedlin.cato.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import xyz.christophermedlin.cato.entities.Ingredient;
import xyz.christophermedlin.cato.repositories.IngredientRepository;
import xyz.christophermedlin.cato.repositories.UsesIngredientRepository;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientRepository repo;
    @Autowired
    UsesIngredientRepository usesRepo;

    @Override
    public Page<Ingredient> findByNameContains(String contains, Pageable page) {
        return repo.findByNameContainsIgnoreCase(contains, page);
    }

    @Override
    public Page<Ingredient> findAll(Pageable page) {
        return repo.findAll(page);
    }
}
