package com.training.expensemanagementsystem.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {


    private static final Map<String, String> users = new HashMap<>();
    static {
        users.put("tufail", "{noop}ahmed123");
        users.put("neha", "{noop}a123");
        users.put("harish", "{noop}jaay");
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        users.put("parth2", "{noop}gg");

        String password = users.get(username);
        if (password == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        User user = new User(username, password, new ArrayList<>());
        System.out.println("#### " + user);
        return user;
    }
}
