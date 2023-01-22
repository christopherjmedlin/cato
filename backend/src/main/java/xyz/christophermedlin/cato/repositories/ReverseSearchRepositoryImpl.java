package xyz.christophermedlin.cato.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import xyz.christophermedlin.cato.entities.Ingredient;
import xyz.christophermedlin.cato.entities.UsesIngredient;

public class ReverseSearchRepositoryImpl implements ReverseSearchRepository {

  @Autowired
  EntityManager em;
  
  @Override
  public List<UsesIngredient> findAllOrderByIngredientUsage(List<Ingredient> ingredients) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<UsesIngredient> cq = cb.createQuery(UsesIngredient.class);

    Root<UsesIngredient> u = cq.from(UsesIngredient.class);

    Predicate[] predicates = new Predicate[ingredients.size()];
    for (int i = 0; i < predicates.length; i++) {
      predicates[i] = cb.equal(u.get("ingredient"), ingredients.get(i).getId());
    }
    Predicate p = cb.or(predicates);
    cq.where(p);
    
    TypedQuery<UsesIngredient> tq =  em.createQuery(cq);
    return tq.getResultList();
  }

}
