package xyz.christophermedlin.cato.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.christophermedlin.cato.assemblers.IngredientCountViewModelAssembler;
import xyz.christophermedlin.cato.assemblers.SmoothieModelAssembler;
import xyz.christophermedlin.cato.entities.Smoothie;
import xyz.christophermedlin.cato.services.SmoothieService;
import xyz.christophermedlin.cato.views.IngredientCountView;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/smoothies")
public class SmoothieController {

    @Autowired
    SmoothieService service;

    @Autowired
    SmoothieModelAssembler modelAssembler;

    @Autowired
    PagedResourcesAssembler<Smoothie> pagedResourcesAssembler;

    @Autowired
    IngredientCountViewModelAssembler icvModelAssembler;

    @Autowired
    PagedResourcesAssembler<IngredientCountView> icvPagedResourcesAssembler;

    @GetMapping("")
    public PagedModel<EntityModel<Smoothie>> index(@PageableDefault(size=10) Pageable page) {
        Page<Smoothie> smoothies = this.service.findAll(page);

        Link link = linkTo(SmoothieController.class)
            .withSelfRel();
        return pagedResourcesAssembler.toModel(smoothies, modelAssembler, link);
    }

    @GetMapping("/{id}")
    public EntityModel<Smoothie> byId(@PathVariable(value="id") Long id) {
        return modelAssembler.toModel(service.findById(id));
    }

    @GetMapping("/ingredientSearch")
    public PagedModel<EntityModel<IngredientCountView>> reverseIngredientSearch(@PageableDefault(size=10) Pageable page,
                                                                                 @RequestParam Set<Long> ingredientIds) {
        Page<IngredientCountView> views;
        if (ingredientIds.size() == 0) { 
            views = service.findAllIngredientCountView(page);
        } else {
            views = this.service.findByIngredientIds(
                page,
                ingredientIds
            );    
        }

        return icvPagedResourcesAssembler.toModel(views, icvModelAssembler);
    }
}
