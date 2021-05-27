package com.devsuperior.myFirstProject.resources;

import com.devsuperior.myFirstProject.entities.Product;
import com.devsuperior.myFirstProject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Define que esta classe será um recurso REST
@RestController
@RequestMapping(path = "/product")
public class ProductResource
{
    // Autowired resolve a dependência para nós
    // Todo framework moderno possui esta funcionalidade

    @Autowired
    private ProductRepository productRepository;
    // Responderá ao GET do http, no caminho /categories
    @GetMapping
    public ResponseEntity<List<Product>> findAll()
    {
        List<Product> list = productRepository.findAll();
        // .ok() resposta que diz que está tudo certo
        // 200 do http
        // no body, colocaremos a lista
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // /product/ + alguma coisa
    public ResponseEntity<Product> findById(@PathVariable Long id)
    {
        Product cat = productRepository.findById(id).get();
        return ResponseEntity.ok().body(cat);
    }
}
