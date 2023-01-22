package xyz.christophermedlin.cato.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.christophermedlin.cato.entities.Ingredient;
import xyz.christophermedlin.cato.entities.UsesIngredient;

@Repository
public interface ReverseSearchRepository {
  public List<UsesIngredient> findAllOrderByIngredientUsage(List<Ingredient> ingredients);
}
