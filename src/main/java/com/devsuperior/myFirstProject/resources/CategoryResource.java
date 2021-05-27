package com.devsuperior.myFirstProject.resources;

import com.devsuperior.myFirstProject.entities.Category;
import com.devsuperior.myFirstProject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// Define que esta classe será um recurso REST
@RestController
@RequestMapping(path = "/categories")
public class CategoryResource
{
    // Autowired resolve a dependência para nós
    // Todo framework moderno possui esta funcionalidade

    @Autowired
    private CategoryRepository categoryRepository;
    // Responderá ao GET do http, no caminho /categories
    @GetMapping
    public ResponseEntity<List<Category>> findAll()
    {
        List<Category> list = categoryRepository.findAll();
        // .ok() resposta que diz que está tudo certo
        // 200 do http
        // no body, colocaremos a lista
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // /categories/ + alguma coisa
    public ResponseEntity<Category> findById(@PathVariable Long id)
    {
        Category cat = categoryRepository.findById(id);
        return ResponseEntity.ok().body(cat);
    }
}
