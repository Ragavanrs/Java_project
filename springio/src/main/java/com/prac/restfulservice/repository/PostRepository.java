package com.prac.restfulservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.restfulservice.User;
import com.prac.restfulservice.common.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	Post findByUser(User user);
}
