package xyz.christophermedlin.cato.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import xyz.christophermedlin.cato.controllers.SmoothieController;
import xyz.christophermedlin.cato.views.IngredientCountView;

@Component
public class IngredientCountViewModelAssembler implements 
  RepresentationModelAssembler<IngredientCountView, EntityModel<IngredientCountView>>{

  @Override
  public EntityModel<IngredientCountView> toModel(IngredientCountView icv) {
    Link smoothieLink = linkTo(methodOn(SmoothieController.class)
      .byId(icv.getId()))
      .withSelfRel();
    return EntityModel.of(icv, smoothieLink);
  }
  
}
