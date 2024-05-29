package com.bfi.backend.common.config;

import com.bfi.backend.admin.auth.AdminClientAuthenticationProvider;
import com.bfi.backend.client.auth.ClientAuthenticationProvider;
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

    private final UserAuthenticationEntryPoint ClientAuthenticationEntryPoint;
    private final ClientAuthenticationProvider ClientAuthenticationProvider;
    private final AdminClientAuthenticationProvider adminClientAuthenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .exceptionHandling(customizer -> customizer.authenticationEntryPoint(ClientAuthenticationEntryPoint))
                .addFilterBefore(new JwtAuthFilter(ClientAuthenticationProvider, adminClientAuthenticationProvider), BasicAuthenticationFilter.class) // Modify this line
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(HttpMethod.POST,  "/**").permitAll()
                        .requestMatchers(HttpMethod.GET,   "/**", "/Clients/**").permitAll()
                        .requestMatchers(HttpMethod.PUT,  "/reset").permitAll()
                        .requestMatchers(HttpMethod.DELETE,  "/Clients/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE,  "/agencies/**").permitAll()
                        .requestMatchers(HttpMethod.PUT,  "/agencies/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE,  "/Clients/**", "adminClients/**").permitAll()
                        .anyRequest().authenticated())

        ;
        return http.build();
    }
}
