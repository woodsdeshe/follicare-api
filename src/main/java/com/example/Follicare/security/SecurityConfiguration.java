package com.example.Follicare.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;



@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public void setMyUserDetailsService(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    /**
     * Creates a bean for the JWTRequestFilter.
     *
     * @return The JWTRequestFilter bean
     */
    @Bean
    public JWTRequestFilter authenticationJwtTokenFilter() {
        return new JWTRequestFilter();
    }

    /**
     * Creates a bean for the BCryptPasswordEncoder.
     *
     * @return The BCryptPasswordEncoder bean
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the security filter chain.
     *
     * @param http The HttpSecurity object
     * @return The configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/auth/users/login", "/auth/users/register", "/api/resources","/api/specialists", "/api/resources/all").permitAll().antMatchers(
                                HttpMethod.GET,
                        "/api/profile", "/api/profile/favorites"
                ).permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable();
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    /**
     * Creates a bean for the AuthenticationManager.
     *
     * @param authConfig The AuthenticationConfiguration object
     * @return The AuthenticationManager bean
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    /**
     * Creates a bean for the DaoAuthenticationProvider.
     *
     * @return The DaoAuthenticationProvider bean
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(myUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     * Creates a bean for MyUserDetails.
     *
     * @return The MyUserDetails bean
     */
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public MyUserDetails myUserDetails() {
        return (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
    }

}