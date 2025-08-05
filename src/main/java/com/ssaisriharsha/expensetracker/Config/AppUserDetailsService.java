package com.ssaisriharsha.expensetracker.Config;

import com.ssaisriharsha.expensetracker.Repository.AppUserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AppUserDetailsService implements UserDetailsService {
    private final AppUserRepo repo;
    public AppUserDetailsService(AppUserRepo repo) {
        this.repo=repo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new SecureUser(repo
                .findByUsername(username)
                .orElseThrow(()->
                        new UsernameNotFoundException("Username " + username + " not found.")
                ));
    }
}
