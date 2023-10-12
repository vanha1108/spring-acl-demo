package com.demo.springacl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();
        var u1 = User.withUsername("user1").password("12345").authorities("read", "write", "delete").build();
        var u2 = User.withUsername("user2").password("12345").authorities("read", "write", "delete").build();
        var admin = User.withUsername("admin").password("12345").authorities("read", "write", "delete", "ADMINISTRATION").build();

        uds.createUser(u1);
        uds.createUser(u2);
        uds.createUser(admin);

        return uds;
    }
}
