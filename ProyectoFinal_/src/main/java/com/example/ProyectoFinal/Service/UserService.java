package com.example.ProyectoFinal.Service;

import com.example.ProyectoFinal.Model.UserModel;
import com.example.ProyectoFinal.Repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(user.getUsername())
                .password("{noop}" + user.getPassword())
                .roles(user.getRole())
                .build();
    }
}