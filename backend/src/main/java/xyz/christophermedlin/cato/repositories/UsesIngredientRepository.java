package xyz.christophermedlin.cato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.christophermedlin.cato.entities.UsesIngredient;

@Repository
public interface UsesIngredientRepository extends JpaRepository<UsesIngredient, Long> {
}
