package xyz.christophermedlin.cato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.christophermedlin.cato.entities.Ingredient;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByNameContainsIgnoreCase(String contains, Pageable pageable);
}
