package xyz.christophermedlin.cato.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xyz.christophermedlin.cato.entities.Smoothie;

@Repository
public interface SmoothieRepository extends JpaRepository<Smoothie, Long> {
  @Query( "SELECT s from UsesIngredient u JOIN u.smoothie s " + 
          "WHERE ingredient.id in :ids")
  List<Smoothie> findByIngredientIds(Pageable page,
                                     @Param("ids") Set<Long> inventoryIds);
}

