package com.zps.service;

import com.zps.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringSecurityUserService2 implements UserDetailsService {
    public Map<String, User> map = new HashMap<>();
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void initUserDate() {
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword(bCryptPasswordEncoder.encode("admin"));
        User user2 = new User();
        user2.setUsername("xiaoming");
        user2.setPassword(bCryptPasswordEncoder.encode("xiaoming"));
        map.put(user1.getUsername(), user1);
        map.put(user2.getUsername(), user2);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        initUserDate();
        User user1 = map.get(username);
        if (user1 == null) {
            return null;
        }

        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("permission_A"));
        list.add(new SimpleGrantedAuthority("permission_B"));
        if ("admin".equals(username)) {
            System.out.println(username);
            list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            list.add(new SimpleGrantedAuthority("add"));
        }
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(username, user1.getPassword(), list);

        return user;

    }
}
