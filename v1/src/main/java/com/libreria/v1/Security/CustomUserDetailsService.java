package com.libreria.v1.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.libreria.v1.Model.UserModel;
import com.libreria.v1.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        UserModel user = userRepository.findByCorreo(correo);

        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return new CustomUserDetails(user);
    }
}
