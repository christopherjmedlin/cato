package xyz.christophermedlin.cato.services;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import xyz.christophermedlin.cato.entities.Smoothie;
import xyz.christophermedlin.cato.views.IngredientCountView;

public interface SmoothieService {

    Smoothie findById(Long id);
    Page<Smoothie> findAll();
    Page<Smoothie> findAll(Pageable page);
    Page<IngredientCountView> findByIngredientIds(Pageable page, Set<Long> ingredients);
    Page<IngredientCountView> findAllIngredientCountView(Pageable page);
}
