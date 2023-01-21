package xyz.christophermedlin.cato.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.christophermedlin.cato.entities.Ingredient;
import xyz.christophermedlin.cato.repositories.IngredientRepository;
import xyz.christophermedlin.cato.repositories.UsesIngredientRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientRepository repo;
    @Autowired
    UsesIngredientRepository usesRepo;

    @Override
    public List<Ingredient> findByNameContains(String contains, Pageable page) {
        return repo.findByNameContainsIgnoreCase(contains, page);
    }

    @Override
    public List<Ingredient> findAll(Pageable page) {
        return repo.findAll(page).toList();
    }
}
