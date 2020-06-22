package com.sps.covoid.tracker.repository;

import com.sps.covoid.tracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Gets id for existing user.
     *
     * @param userName the user name
     * @param password the password
     * @return the id for existing user
     */
    @Query("select u.id from USER u where u.userName =?1 and u.password = ?2")
    Long getIdForExistingUser(String userName, String password);
}
