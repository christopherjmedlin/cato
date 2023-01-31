package xyz.christophermedlin.cato.entities;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Smoothie {
    private @Id @GeneratedValue Long id;
    private String name;

    @OneToMany(mappedBy = "smoothie")
    private Set<UsesIngredient> ingredients;

    // to combine names of ingredients with the quantity used
    public class IngredientUsageView {
        private long id;
        private String name;
        private MeasurementUnit unit;
        private float unitValue;

        public IngredientUsageView(long id, String name, MeasurementUnit unit, float unitValue) {
            this.id = id;
            this.name = name;
            this.unit = unit;
            this.unitValue = unitValue;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public MeasurementUnit getUnit() {
            return unit;
        }

        public float getUnitValue() {
            return unitValue;
        }
    }

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

    public Set<IngredientUsageView> getIngredients() {
        return this.ingredients.stream()
                .map(x -> {
                    return new IngredientUsageView(
                        x.getIngredient().getId(),
                        x.getIngredient().getName(),
                        x.getUnit(),
                        x.getUnitValue()
                    );
                })
                .collect(Collectors.toSet());
    }

    public void setName(String name) {
        this.name = name;
    }
}
