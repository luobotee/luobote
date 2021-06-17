package com.java.securityauthserver.details;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.java.securityauthserver.entity.User;
import com.java.securityauthserver.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getOne(new QueryWrapper<User>()
                .eq("username", username));
        if (user == null) {
            throw new UsernameNotFoundException("无效用户名");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (user.getUsername().equals("admin")) {
            authorities.add(new SimpleGrantedAuthority("admin"));
        } else {
            authorities.add(new SimpleGrantedAuthority("user"));
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
        return userDetails;
    }
}
