package xyz.christophermedlin.cato.entities;

import jakarta.persistence.*;

@Entity
public class UsesIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "smoothie_id")
    private Smoothie smoothie;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public UsesIngredient(Smoothie smoothie, Ingredient ingredient) {
        this.smoothie = smoothie;
        this.ingredient = ingredient;
    }

    public UsesIngredient() {}

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Smoothie getSmoothie() {
        return smoothie;
    }
}
