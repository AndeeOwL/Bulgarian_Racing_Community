package com.andreanbuhchev.bulgarian_racing_community.model.repository;

import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    List<UserRoleEntity> findById(long id);

}
