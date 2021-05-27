package com.devsuperior.myFirstProject.repositories;

import com.devsuperior.myFirstProject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Component? Mecanismo de injeção de dependência do spring boot
// @Component
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{}