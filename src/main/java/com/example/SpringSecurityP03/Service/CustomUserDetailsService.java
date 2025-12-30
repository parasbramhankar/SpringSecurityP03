//package com.example.SpringSecurityP03.Service;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        if(!username.equals("paras")){
//            throw  new UsernameNotFoundException("user not found");
//        }
//
//        String encodePass=new BCryptPasswordEncoder().encode("root");
//
//        return User.withUsername(username).password(encodePass).roles("ADMIN").build();
//    }
//}
