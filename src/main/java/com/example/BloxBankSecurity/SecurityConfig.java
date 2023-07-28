package com.example.BloxBankSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
@Bean
    public UserDetailsService userDetailsService(){
        UserDetails admin= User.builder().username("CEO")
                .password(bCryptPasswordEncoder().encode("123456"))
                .roles("ADMIN")
                .build();
        UserDetails customer=User.builder().username("Sanoj")
                .password(bCryptPasswordEncoder().encode("12345"))
                .roles("SDE")
                .build();
        return new InMemoryUserDetailsManager(admin,customer);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/public/**")
               .permitAll()
               .requestMatchers(("/transfer/**")).hasRole("ADMIN")
               .anyRequest()
                .authenticated()
                .and()
                .formLogin();
               return httpSecurity.build();

    }

}
