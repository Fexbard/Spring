package com.OBSpringBoot.Ejercicio101112.Config;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)

class SecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/laptops/**").permitAll()
                .requestMatchers("/api/modify/laptops/{id}").hasRole("ADMIN")
                .requestMatchers("/api/delete/{id}").hasRole("ADMIN")
                .requestMatchers("/api/add/laptops").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().formLogin();

        return http.build();
    }

//El UserDetailsService es el dministrador de credenciales de usuarios de Spring
    @Bean
    UserDetailsService userDetailsService() {
    InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
    userDetailsManager.createUser(User.withUsername("admin")
            .password(passwordEncoder().encode("admin"))
            .roles("ADMIN")
            .build());
    userDetailsManager.createUser(User.withUsername("user")
            .password(passwordEncoder().encode("user"))
            .roles("USER")
            .build());
    return userDetailsManager;
    }

    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }




    //Confiración alternativa
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user1 = User.withUsername("user1")
//                .password(passwordEncoder().encode("pws1"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user2 = User.withUsername("user2")
//                .password(passwordEncoder().encode("pws2"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

    //    @Bean
//    public HttpFirewall firewallExcep(){
//        StrictHttpFirewall firewall = new StrictHttpFirewall();
//        firewall.setAllowSemicolon(true);
//        return firewall;
//    }



}

