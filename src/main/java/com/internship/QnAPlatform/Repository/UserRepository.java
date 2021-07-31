package com.internship.QnAPlatform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internship.QnAPlatform.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
