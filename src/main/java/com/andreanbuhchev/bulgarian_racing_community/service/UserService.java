package com.andreanbuhchev.bulgarian_racing_community.service;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.UserRegisterDto;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserRoleEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {


    void initAdmin(List<UserRoleEntity> roles);

    void init();

    void registerAndLogin(UserRegisterDto userRegisterDto);

    void login(UserEntity userEntity);
}
