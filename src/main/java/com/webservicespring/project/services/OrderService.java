package com.webservicespring.project.services;

import com.webservicespring.project.entities.Order;
import com.webservicespring.project.entities.User;
import com.webservicespring.project.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        try{
        return orderRepository.findAll();
        } catch (RuntimeException e ){
            e.getMessage();
            throw new RuntimeException
                    ("Erro ao tentar buscar todos os pedidos", e);
        }
    }

    public Order findById(Long id){
        try{
            Optional<Order> obj = orderRepository.findById(id);
            return obj.get();
        } catch (RuntimeException e ){
            e.getMessage();
            throw new RuntimeException
                    ("Erro ao tentar buscar usuário por id", e);
        }
    }

}
