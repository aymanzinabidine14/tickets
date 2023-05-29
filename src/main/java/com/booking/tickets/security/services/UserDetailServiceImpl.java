package com.booking.tickets.security.services;

import com.booking.tickets.security.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=accountService.loadUserByUsename(username);
        if(user==null) throw new UsernameNotFoundException(String.format("User %s not found",username));

        String[] roles=user.getRoles().stream().map(u -> u.getRole()).toArray(String[]::new);
        UserDetails userDetails= org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername()).password(user.getPassword()).roles(roles).build();
        return userDetails;
    }
}
