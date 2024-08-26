package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.User;
import com.project.exceptions.ResourceNotFoundException;
import com.project.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.get(); // retorna o objeto que estiver no optional
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    /*
     * public User update(Long id, User obj) {
     * User entity = userRepository.getReferenceById(id);// instancia/prepara o obj
     * monitorado pelo jpa mas n salva no
     * // banco.
     * updateData(entity, obj);
     * return userRepository.save(entity);
     * }
     * 
     * private void updateData(User entity, User obj) {
     * entity.setName(obj.getName());
     * entity.setEmail(obj.getEmail());
     * entity.setPhone(obj.getPhone());
     * }
     */

    // implementação com getById. getReferenceById retornando not allowed(idk w)
    // por isso a implementação da pesquisa no banco
    public User update(Long id, User obj) {
        Optional<User> optUser = userRepository.findById(id);

        User entity = optUser.orElseThrow(() -> new ResourceNotFoundException("User not Found with id " + id));
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
