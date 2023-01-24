package xyz.christophermedlin.cato.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xyz.christophermedlin.cato.entities.Smoothie;
import xyz.christophermedlin.cato.views.IngredientCountView;

@Repository
public interface SmoothieRepository extends JpaRepository<Smoothie, Long> {
  @Query( "SELECT s.id AS id, s.name AS name, COUNT(u.ingredient) AS count " + 
          "FROM UsesIngredient u JOIN u.smoothie s " + 
          "WHERE ingredient.id in :ids " +
          "GROUP BY u.smoothie " +
          "ORDER BY COUNT(u.ingredient) DESC" )
  List<IngredientCountView> findByIngredientIds(Pageable page,
                                                @Param("ids") Set<Long> inventoryIds);

  @Query( "SELECT s.id AS id, s.name AS name, 0 AS count " +
          "FROM Smoothie AS s" )
  List<IngredientCountView> findAllIngredientCountView(Pageable page);
}

