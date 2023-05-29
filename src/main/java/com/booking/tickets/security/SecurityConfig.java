package com.booking.tickets.security;

import com.booking.tickets.security.services.UserDetailServiceImpl;
import jakarta.jws.soap.SOAPBinding;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@EnableWebSecurity
@Configuration
@AllArgsConstructor

public class SecurityConfig {


     @Autowired
    PasswordEncoder passwordEncoder;
     @Autowired
    private UserDetailServiceImpl userDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.formLogin();
        httpSecurity.authorizeHttpRequests().requestMatchers("createTicket","saveTicket").hasAnyAuthority("ROLE_ADMIN","ROLE_MODERATOR");
        httpSecurity.authorizeHttpRequests().requestMatchers("updateTicket","showTicket","deleteTicket").hasAnyAuthority("ROLE_ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("ticketList").hasAnyAuthority("ROLE_ADMIN","ROLE_MODERATOR","ROLE_USER");
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        httpSecurity.exceptionHandling().accessDeniedPage("/accessDenied");
        httpSecurity.userDetailsService(userDetailService);
        return httpSecurity.build();
    }


    //@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new  InMemoryUserDetailsManager(
                User.withUsername("admin").password(passwordEncoder.encode("123")).roles("ADMIN","USER").build(),
                User.withUsername("moderator").password(passwordEncoder.encode("123")).roles("MODERATOR").build(),
                User.withUsername("user").password(passwordEncoder.encode("123")).roles("USER").build()
                );
    }

    //@Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


}
