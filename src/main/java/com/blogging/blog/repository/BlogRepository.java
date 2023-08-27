package com.blogging.blog.repository;

import com.blogging.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, String> {
}
