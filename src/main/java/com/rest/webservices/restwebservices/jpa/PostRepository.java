package com.rest.webservices.restwebservices.jpa;

import com.rest.webservices.restwebservices.user.Post;
import com.rest.webservices.restwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
