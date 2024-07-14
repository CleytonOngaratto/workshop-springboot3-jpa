package com.webservicespring.project.services;

import com.webservicespring.project.entities.User;
import com.webservicespring.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        try{
        return userRepository.findAll();
        } catch (RuntimeException e ){
            e.getMessage();
            throw new RuntimeException
                    ("Erro ao tentar buscar todos os usuários", e);
        }
    }

    public User findById(Long id){
        try{
            Optional<User> obj = userRepository.findById(id);
            return obj.get();
        } catch (RuntimeException e ){
            e.getMessage();
            throw new RuntimeException
                    ("Erro ao tentar buscar usuário por id", e);
        }
    }

}
