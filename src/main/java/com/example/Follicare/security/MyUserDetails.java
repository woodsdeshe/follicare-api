package com.example.Follicare.security;


import com.example.Follicare.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class MyUserDetails implements UserDetails {

    private final User user;


    public MyUserDetails(User user){
        this.user = user;
    }


    public User getUser(){
        return user;
    }

    /**
     * Returns the authorities granted to the user.
     *
     * @return The authorities granted to the user
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<>();
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return The password used to authenticate the user
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Returns the username used to authenticate the user.
     *
     * @return The username used to authenticate the user
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Indicates whether the user's account has expired.
     *
     * @return true if the user's account is valid (not expired), false otherwise
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked.
     *
     * @return true if the user is not locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired.
     *
     * @return true if the user's credentials are valid (not expired), false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled.
     *
     * @return true if the user is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}