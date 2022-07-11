package com.andreanbuhchev.bulgarian_racing_community.service;

import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserRoleEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.UserRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.user.AppUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class AppUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return userRepository.
                    findByUsername(username).
                    map(this::map).
                    orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        }


    private UserDetails map (UserEntity userEntity) {

            return new AppUserDetails (
                    userEntity.getPassword(),
                    userEntity.getUsername(),
                    userEntity.getFirstName(),
                    userEntity.getLastName(),
                    userEntity.
                            getRole().
                            stream().
                            map(this::map).
                            toList()
            );
    }

    private GrantedAuthority map(UserRoleEntity getUserRole){
        return new SimpleGrantedAuthority("ROLE_" + getUserRole.getRole().name());
    }

}


