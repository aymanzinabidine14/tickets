package com.booking.tickets.security.services;

import com.booking.tickets.security.entities.Role;
import com.booking.tickets.security.entities.User;
import com.booking.tickets.security.repositories.RoleRepository;
import com.booking.tickets.security.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.taglibs.standard.lang.jstl.NullLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class AccountServiceImp implements AccountService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User createUser(String username, String password, String email, String confirmPassword) {

        User user=userRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("EXIST");
        if(!password.equals(confirmPassword)) throw new RuntimeException("ERROR");
                user =User.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        return userRepository.save(user);
    }

    @Override
    public Role createRole(String role) {
        Role role1=roleRepository.findById(role).orElse(null);
                role1= Role.builder().role(role).build();
        return roleRepository.save(role1);
    }

    @Override
    public void addRoletoUser(String username, String role) {
        User user=userRepository.findByUsername(username);
        Role role1=roleRepository.findById(role).orElse(null);
        user.getRoles().add(role1);

    }

    @Override
    public User loadUserByUsename(String username) {
        return userRepository.findByUsername(username);
    }


}
