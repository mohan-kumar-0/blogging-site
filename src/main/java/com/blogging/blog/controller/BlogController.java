package com.blogging.blog.controller;

import com.blogging.blog.entity.Blog;
import com.blogging.blog.service.BlogService;
import com.blogging.blog.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired UserService userService;

    @GetMapping("/blog")
    public String getBlogById(@Valid @RequestBody String blogId){
        return blogService.getBlog(blogId).toString();
    }

    @GetMapping("/blog/all")
    public List<Blog> getAllBlogs(){
        List<Blog> allBlogs = blogService.getBlogList();
        return allBlogs;
    }

    @GetMapping("/blog/getauthor")
    public String getAuthorDetails(@Valid @RequestBody String blogId){
        return blogService.getAuthorDetails(blogId).toString();
    }

    @PostMapping("/blog/publish")
    public String publishBlog(@Valid @RequestBody Blog blog){

        blog.setUser(userService.findByEmail(blog.getUser().getEmail()));
        if(blogService.publishBlog(blog))
            return "Published blog " + blog.toString();
        throw new RuntimeException("Could not publish blog");
    }

    @PutMapping("/blog/update")
    public String updateBlog(@Valid @RequestBody Blog blog){
        if(blogService.updateBlog(blog))
            return "Updated blog fileds " + blog.toString();
        throw new RuntimeException("Could not update blog");
    }

    @DeleteMapping("/blog/delete")
    public String deleteBlog(@Valid @RequestBody String blogId){
        if(blogService.deleteBlog(blogId))
            return "Deleted blog " + blogId;
        throw new RuntimeException("Could not delete blog");
    }
}
