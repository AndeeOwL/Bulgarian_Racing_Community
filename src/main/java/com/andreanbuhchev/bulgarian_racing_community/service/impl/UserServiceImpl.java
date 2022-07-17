package com.andreanbuhchev.bulgarian_racing_community.service.impl;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.UserRegisterDto;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserRoleEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.enums.RoleEnum;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.UserRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.UserRoleRepository;
import com.andreanbuhchev.bulgarian_racing_community.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final String adminPass;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository,
                           UserRoleRepository userRoleRepository,
                           PasswordEncoder passwordEncoder,
                           UserDetailsService userDetailsService, @Value("admin") String adminPass, ModelMapper modelMapper)  {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.adminPass = adminPass;
        this.modelMapper = modelMapper;
    }
    public void init() {
        if (userRepository.count() == 0 && userRoleRepository.count() == 0) {

            UserRoleEntity adminRole = new UserRoleEntity();
            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setRole(RoleEnum.USER);
            adminRole.setRole(RoleEnum.ADMIN);
            userRoleRepository.save(adminRole);
            userRoleRepository.save(userRole);

            initAdmin(List.of(adminRole,userRole));

        }
    }

    @Override
    public void initAdmin(List<UserRoleEntity> roles) {
        UserEntity admin = new UserEntity();

                admin.setRole(roles);
                admin.setFirstName("Andrean");
                admin.setLastName("Buhchev");
                admin.setUsername("andeeowl");
                admin.setEmail("andeeowl@yahoo.com");
                admin.setPassword(passwordEncoder.encode(adminPass));

        userRepository.save(admin);
    }

    @Override
    public void registerAndLogin(UserRegisterDto userRegisterDto) {
        UserEntity newUser = new UserEntity();

            modelMapper.map(userRegisterDto,newUser);
            newUser.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
            newUser.setRole(userRoleRepository.findById(2));

            userRepository.save(newUser);
            login(newUser);
        }


    @Override
    public void login(UserEntity userEntity) {
                UserDetails userDetails =
                        userDetailsService.loadUserByUsername(userEntity.getUsername());

                Authentication auth =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                userDetails.getPassword(),
                                userDetails.getAuthorities()
                        );

                SecurityContextHolder.
                        getContext().
                        setAuthentication(auth);
            }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAllByRoleNotLike("ADMIN");
    }

}


