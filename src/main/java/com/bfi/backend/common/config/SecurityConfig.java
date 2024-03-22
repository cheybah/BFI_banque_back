package com.bfi.backend.common.config;

import com.bfi.backend.admin.auth.AdminUserAuthenticationProvider;
import com.bfi.backend.admin.enums.AdminRole;
import com.bfi.backend.client.auth.UserAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
    private final UserAuthenticationProvider userAuthenticationProvider;
    private final AdminUserAuthenticationProvider adminUserAuthenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .exceptionHandling(customizer -> customizer.authenticationEntryPoint(userAuthenticationEntryPoint))
                .addFilterBefore(new JwtAuthFilter(userAuthenticationProvider, adminUserAuthenticationProvider), BasicAuthenticationFilter.class) // Modify this line
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(HttpMethod.POST,  "/**").permitAll()
                        .requestMatchers(HttpMethod.GET,   "/**", "/users/**").permitAll()
                        .requestMatchers(HttpMethod.PUT,  "/reset").permitAll()
                        .requestMatchers(HttpMethod.DELETE,  "/users/**", "adminUsers/**").permitAll()
                        .anyRequest().authenticated())

        ;
        return http.build();
    }
}
