package com.goalshare.project.goalsharerest.repository;

import com.goalshare.project.goalsharerest.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find by username optional.
     *
     * @param userName the user name
     * @return the optional
     */
    Optional<User> findByUsername(String userName);
}
