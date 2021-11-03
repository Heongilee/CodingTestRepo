package com.vanillabridge.lounge.Controller.Repository;

import com.vanillabridge.lounge.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
