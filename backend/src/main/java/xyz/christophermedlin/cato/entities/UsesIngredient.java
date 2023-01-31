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

    @Enumerated(EnumType.ORDINAL)
    private MeasurementUnit unit;

    @Column(precision=8)
    private float unitValue;

    public UsesIngredient(Smoothie smoothie,
                          Ingredient ingredient,
                          MeasurementUnit unit,
                          float unitValue) {
        this.smoothie = smoothie;
        this.ingredient = ingredient;
        this.unit = unit;
        this.unitValue = unitValue;
    }

    public UsesIngredient() {}

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Smoothie getSmoothie() {
        return smoothie;
    }

    public MeasurementUnit getUnit() {
        return this.unit;
    }
    
    public float getUnitValue() {
        return this.unitValue;
    }
}
