package xyz.christophermedlin.cato.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.christophermedlin.cato.entities.Smoothie;
import xyz.christophermedlin.cato.services.SmoothieService;
import xyz.christophermedlin.cato.views.IngredientCountView;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/smoothies")
public class SmoothieController {

    @Autowired
    SmoothieService service;

    @GetMapping("")
    public CollectionModel<EntityModel<Smoothie>> index(@RequestParam(required = false) Optional<Integer> page) {
        List<EntityModel<Smoothie>> smoothies = this.service.findAll(
                PageRequest.of((int) page.orElseGet(() -> 0), 10)
        ).stream().map(EntityModel::of).collect(Collectors.toList());

        for (EntityModel<Smoothie> s : smoothies) {
            Link selfLink = linkTo(methodOn(SmoothieController.class)
                .byId(s.getContent().getId()))
                .withSelfRel();
            s.add(selfLink);
        }

        Link link = linkTo(SmoothieController.class)
            .withSelfRel();
        CollectionModel<EntityModel<Smoothie>> collection = CollectionModel.of(smoothies, link);
        return collection;
    }

    @GetMapping("/{id}")
    public EntityModel<Smoothie> byId(@PathVariable(value="id") Long id) {
        Link self = linkTo(SmoothieController.class).slash(id).withSelfRel();
        return EntityModel.of(service.findById(id), self);
    }

    @GetMapping("/ingredientSearch")
    public List<IngredientCountView> reverseIngredientSearch(@RequestParam(required = false) Optional<Integer> page,
                                                  @RequestParam Set<Long> ingredientIds) {
        if (ingredientIds.size() == 0) { 
            return service.findAllIngredientCountView(
                PageRequest.of((int) page.orElseGet(() -> 0), 10)
            );
        }
        return this.service.findByIngredientIds(
            PageRequest.of((int) page.orElseGet(() -> 0), 10), 
            ingredientIds
        );                                                
    }
}
