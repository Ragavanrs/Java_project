package com.prac.restfulservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.restfulservice.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
