package com.restapi_practice.repository.post;

import com.restapi_practice.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post, Long> {


}
