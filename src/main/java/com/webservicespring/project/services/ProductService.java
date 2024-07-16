package com.webservicespring.project.services;

import com.webservicespring.project.entities.Product;
import com.webservicespring.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        try{
        return productRepository.findAll();
        } catch (RuntimeException e ){
            e.getMessage();
            throw new RuntimeException
                    ("Erro ao tentar buscar todos os usuários", e);
        }
    }

    public Product findById(Long id){
        try{
            Optional<Product> obj = productRepository.findById(id);
            return obj.get();
        } catch (RuntimeException e ){
            e.getMessage();
            throw new RuntimeException
                    ("Erro ao tentar buscar usuário por id", e);
        }
    }

}
