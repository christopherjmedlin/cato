package xyz.christophermedlin.cato.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import xyz.christophermedlin.cato.controllers.SmoothieController;
import xyz.christophermedlin.cato.entities.Smoothie;

@Component
public class SmoothieModelAssembler implements RepresentationModelAssembler<Smoothie, EntityModel<Smoothie>> {
  
  @Override
  public EntityModel<Smoothie> toModel(Smoothie smoothie) {
    Link link = linkTo(methodOn(SmoothieController.class)
      .byId(smoothie.getId()))
      .withSelfRel();
    return EntityModel.of(smoothie, link);
  }
}
