package xyz.christophermedlin.cato.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.christophermedlin.cato.entities.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Page<Ingredient> findByNameContainsIgnoreCase(String contains, Pageable pageable);
}
