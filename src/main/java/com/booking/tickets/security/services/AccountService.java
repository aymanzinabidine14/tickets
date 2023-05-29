package com.booking.tickets.security.services;

import com.booking.tickets.security.entities.Role;
import com.booking.tickets.security.entities.User;

public interface AccountService  {


    User createUser(String username, String password, String email, String confirmPassword);
    Role createRole(String role);

    void addRoletoUser(String username,String role);

    User loadUserByUsename(String username);



}
