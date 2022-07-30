package com.andreanbuhchev.bulgarian_racing_community.service.impl;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.UserRegisterDto;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.ShoppingCart;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserRoleEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.enums.RoleEnum;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.ShoppingCartRepository;
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

import javax.transaction.Transactional;
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
    private final ShoppingCartRepository shoppingCartRepository;


    public UserServiceImpl(UserRepository userRepository,
                           UserRoleRepository userRoleRepository,
                           PasswordEncoder passwordEncoder,
                           UserDetailsService userDetailsService, @Value("admin") String adminPass, ModelMapper modelMapper, ShoppingCartRepository shoppingCartRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.adminPass = adminPass;
        this.modelMapper = modelMapper;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void init() {
        if (userRepository.count() == 0 && userRoleRepository.count() == 0) {

            UserRoleEntity adminRole = new UserRoleEntity();
            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setRole(RoleEnum.USER);
            adminRole.setRole(RoleEnum.ADMIN);
            userRoleRepository.save(adminRole);
            userRoleRepository.save(userRole);

            initAdmin(List.of(adminRole, userRole));

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
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUserEntity(admin);
        shoppingCartRepository.save(shoppingCart);

    }

    @Override
    public void registerAndLogin(UserRegisterDto userRegisterDto) {
        UserEntity newUser = new UserEntity();

        modelMapper.map(userRegisterDto, newUser);
        newUser.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        newUser.setRole(userRoleRepository.findById(2));
        ShoppingCart shoppingCart = new ShoppingCart();

        userRepository.save(newUser);
        shoppingCart.setUserEntity(newUser);
        shoppingCartRepository.save(shoppingCart);


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
        List<UserEntity> allUsers = userRepository.findAll();

        List<UserEntity> usersWithoutAdmins = new ArrayList<>();

        allUsers.stream().forEach(u -> {
            if(u.getRole().size() <= 1) {
                usersWithoutAdmins.add(u);
            }
        });


        return usersWithoutAdmins;
    }

    @Override
    @Transactional
    public void addRoleToUser(Long id) {

        UserEntity user = userRepository.findById(id).orElseThrow();

        List <UserRoleEntity> userRoleEntity = userRoleRepository.findById(1);

        user.getRole().add(1,userRoleEntity.get(0));

    }

    @Override
    public void deleteUser(Long id) {

        shoppingCartRepository.deleteById(id);
        userRepository.deleteById(id);
    }

}


