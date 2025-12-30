package com.example.SpringSecurityP03.config;


//import com.example.SpringSecurityP03.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class webConfig {

//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity.authorizeHttpRequests(req ->
                req.requestMatchers("/security/aboutUs", "/security/contactUs").permitAll().anyRequest().authenticated()
        ).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
//        AuthenticationManagerBuilder builder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
//
//        builder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//
//        return builder.build();
//    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails user1= User.builder().username("paras").password(passwordEncoder().encode("paras")).roles("ADMIN").build();

        UserDetails user2=User.builder().username("prachi").password(passwordEncoder().encode("prachi")).roles("USER").build();

        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
