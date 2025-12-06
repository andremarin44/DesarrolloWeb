package com.libreria.v1.Service;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.libreria.v1.Model.UserModel;
import com.libreria.v1.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Listar todos
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    // Guardar usuario con password encriptado
    public UserModel saveUser(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Buscar por ID
    public UserModel findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Actualizar
    public void update(UserModel user) {
        userRepository.save(user);
    }

    // Eliminar
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    
    public void save(UserModel user) {
        userRepository.save(user);
    }
}
