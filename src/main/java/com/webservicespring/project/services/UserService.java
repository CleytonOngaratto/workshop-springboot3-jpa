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
        try {
            return userRepository.findAll();
        } catch (RuntimeException e) {
            e.getMessage();
            throw new RuntimeException
                    ("Erro ao tentar buscar todos os usuários", e);
        }
    }

    public User findById(Long id) {
        try {
            Optional<User> obj = userRepository.findById(id);
            return obj.get();
        } catch (RuntimeException e) {
            e.getMessage();
            throw new RuntimeException
                    ("Erro ao tentar buscar usuário por id", e);
        }
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User entity = userRepository.getReferenceById(id); // diferente do findById, esse aqui apenas monitora o objeto pelo jpa, sem trazer de fato do banco de dados. Mais eficiente
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
