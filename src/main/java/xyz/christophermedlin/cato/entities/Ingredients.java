package xyz.christophermedlin.cato.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredients {
    private @Id @GeneratedValue Long id;
    private String name;

    public Ingredients() {
        this.name = name;
    }
    public Ingredients(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
