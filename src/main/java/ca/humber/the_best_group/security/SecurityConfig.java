package ca.humber.the_best_group.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    @Lazy
    private UserDetailsService userDetailsService;
    
    @Bean
    public SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/inventory/**").hasAnyRole("STAFF", "MANAGER")
                    .requestMatchers("/management/**").hasRole("MANAGER") 
                    .requestMatchers("/", "/js/**", "/css/**", "/images/**", "/h2-console/**").permitAll()
                    .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                .headers(headers -> headers.frameOptions(f -> f.disable()))
                .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true) 
                    .permitAll())
                .exceptionHandling(exception -> exception.accessDeniedPage("/permission-denied"))
                .logout(logout -> logout.permitAll())
                .build();
    }
    
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
