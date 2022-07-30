package com.andreanbuhchev.bulgarian_racing_community.service;

import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserRoleEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.enums.RoleEnum;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.UserRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.user.AppUserDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AppUserDetailsServiceTest {

    @Mock
    private UserRepository mockUserRepository;

    private AppUserDetailsService toTest;

    @BeforeEach
    void setUp(){
        toTest = new AppUserDetailsService(mockUserRepository);
    }

    @Test
    void testLoadUserByUserName_UserExist(){

        //ARRANGE

        UserEntity testUserEntity =
                new UserEntity().
                        setEmail("test@email").
                        setPassword("testPassword").
                        setUsername("testUsername").
                        setFirstName("testFirstName").
                        setLastName("testLastName")
                        .setRole(
                                List.of(
                                new UserRoleEntity().setRole(RoleEnum.USER),
                                new UserRoleEntity().setRole(RoleEnum.ADMIN)
                                )
                        );

        when(mockUserRepository.findByUsername(testUserEntity.getUsername())).thenReturn(Optional.of(testUserEntity));

        // ACT


       AppUserDetails userDetails = (AppUserDetails) toTest.loadUserByUsername(testUserEntity.getUsername());

        // ASSERT

        Assertions.assertEquals(testUserEntity.getUsername(),userDetails.getUsername());
        Assertions.assertEquals(testUserEntity.getFirstName(),userDetails.getFirstName());
        Assertions.assertEquals(testUserEntity.getLastName(),userDetails.getLastName());
        Assertions.assertEquals(testUserEntity.getFirstName() +" "+testUserEntity.getLastName(),userDetails.getFullName());
        Assertions.assertEquals(testUserEntity.getPassword(),userDetails.getPassword());
        Assertions.assertEquals(2,userDetails.getAuthorities().size());
        Assertions.assertEquals(testUserEntity.getPassword(),userDetails.getPassword());


    }

    @Test
    void testLoadUserByUserName_UserDoesNotExist(){

        // ARRANGE
        // NO NEED TO ARRANGE ANYTHING ,MOCKS RETURN EMPTY OPTIONALS


        // ACT AND ASSERT
        Assertions.assertThrows(UsernameNotFoundException.class,() -> toTest.loadUserByUsername("notActualEmail@com"));


    }
}
