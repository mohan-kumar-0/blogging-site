package com.blogging.blog.service;

import com.blogging.blog.entity.Blog;
import com.blogging.blog.entity.User;

import java.util.List;

public interface BlogService {
    public Blog getBlog(String blogId);
    public List<Blog> getBlogList();
    public User getAuthorDetails(String blogId);
    public boolean publishBlog(Blog blog);
    public boolean updateBlog(Blog blog);
    public boolean deleteBlog(String blogId);
}
