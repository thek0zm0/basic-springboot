package com.devsuperior.myFirstProject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Entity
public class Category implements Serializable
{
    private static final long serialVersionUID = 1L;
    /* Poderia ser Integer no id?
       Sim, bem de boas....
       Poderia ser int ou long no id?
       Não recomendado, pq o tipo wrapper permite que:
       Primeiro: Utilizemos null.
       Segundo: É importante também para que o tipo aceite qualquer tipo de herança e polimorfismo.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Tomar cuidado com associação ciclica
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    public Category(){}

    public Category(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Product> getProducts()
    {
        return products;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
