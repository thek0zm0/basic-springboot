package com.devsuperior.myFirstProject.repositories;

import com.devsuperior.myFirstProject.entities.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Component? Mecanismo de injeção de dependência do spring boot
@Component
public class CategoryRepository
{
    // Map é uma coleção de pares chave/valor,
    // Vou guardar uma coleção de long id e categorias
    // Assim será mais fácil buscar a category de dada id
    // Map é uma interface em Java
    private Map<Long, Category> map = new HashMap<>();

    public void save(Category obj)
    {
        map.put(obj.getId(), obj);
    }

    public Category findById(Long id)
    {
        return map.get(id);
    }

    public List<Category> findAll()
    {
        return new ArrayList<Category>(map.values());
    }
}