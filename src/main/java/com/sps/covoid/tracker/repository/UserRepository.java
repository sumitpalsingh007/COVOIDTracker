package com.sps.covoid.tracker.repository;

import com.sps.covoid.tracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u.id from USER u where u.userName =?1 and u.password = ?2")
    Long getIdForExistingUser(String userName, String password);
}
