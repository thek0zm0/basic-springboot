package com.devsuperior.myFirstProject.repositories;

import com.devsuperior.myFirstProject.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Component? Mecanismo de injeção de dependência do spring boot
@Component
public class ProductRepository
{
    // Map é uma coleção de pares chave/valor,
    // Vou guardar uma coleção de long id e categorias
    // Assim será mais fácil buscar a Product de dada id
    // Map é uma interface em Java
    private Map<Long, Product> map = new HashMap<>();

    public void save(Product obj)
    {
        map.put(obj.getId(), obj);
    }

    public Product findById(Long id)
    {
        return map.get(id);
    }

    public List<Product> findAll()
    {
        return new ArrayList<Product>(map.values());
    }
}