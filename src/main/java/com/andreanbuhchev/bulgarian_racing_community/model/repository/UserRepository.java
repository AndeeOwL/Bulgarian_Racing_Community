package com.andreanbuhchev.bulgarian_racing_community.model.repository;

import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByUsername(String username);

    List<UserEntity> findAll();

}
