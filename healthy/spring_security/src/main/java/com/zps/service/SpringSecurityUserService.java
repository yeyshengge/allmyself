package com.zps.service;

import com.zps.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringSecurityUserService implements UserDetailsService {
    public  static Map<String, User> map = new HashMap<>();

    static {
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("admin");
        User user2 = new User();
        user2.setUsername("xiaoming");
        user2.setPassword("xiaoming");
        map.put(user1.getUsername(), user1);
        map.put(user2.getUsername(), user2);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
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
        }
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(username, "{noop}" + user1.getPassword(), list);

        return user;

    }
}
