package com.webservicespring.project.services;

import com.webservicespring.project.entities.Category;
import com.webservicespring.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        try{
        return categoryRepository.findAll();
        } catch (RuntimeException e ){
            e.getMessage();
            throw new RuntimeException
                    ("Erro ao tentar buscar todas as categorias", e);
        }
    }

    public Category findById(Long id){
        try{
            Optional<Category> obj = categoryRepository.findById(id);
            return obj.get();
        } catch (RuntimeException e ){
            e.getMessage();
            throw new RuntimeException
                    ("Erro ao tentar buscar categoria por id", e);
        }
    }

}
