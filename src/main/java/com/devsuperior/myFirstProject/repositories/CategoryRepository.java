package com.devsuperior.myFirstProject.repositories;

import com.devsuperior.myFirstProject.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Component? Mecanismo de injeção de dependência do spring boot
// @Component
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>
{
}