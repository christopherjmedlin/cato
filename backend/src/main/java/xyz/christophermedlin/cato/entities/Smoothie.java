package xyz.christophermedlin.cato.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Smoothie {
    private @Id @GeneratedValue Long id;
    private String name;

    @OneToMany(mappedBy = "smoothie")
    private Set<UsesIngredient> ingredients;

    public Smoothie() {
        this.name = "";
    }

    public Smoothie(String name) {
        this.name = name;
        this.ingredients = new HashSet<>();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Set<Ingredient> getIngredients() {
        return this.ingredients.stream()
                .map(UsesIngredient::getIngredient)
                .collect(Collectors.toSet());
    }

    public void setName(String name) {
        this.name = name;
    }
}
