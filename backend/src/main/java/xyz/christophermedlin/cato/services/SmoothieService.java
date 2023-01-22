package xyz.christophermedlin.cato.services;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;

import xyz.christophermedlin.cato.entities.Smoothie;
import xyz.christophermedlin.cato.views.IngredientCountView;

public interface SmoothieService {

    Smoothie findById(Long id);
    List<Smoothie> findAll();
    List<Smoothie> findAll(Pageable page);
    List<IngredientCountView> findByIngredientIds(Pageable page, Set<Long> ingredients);
}
