package com.blogging.blog.service;

import com.blogging.blog.entity.Blog;
import com.blogging.blog.entity.User;
import com.blogging.blog.repository.BlogRepository;
import com.blogging.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public Blog getBlog(String blogId) {
        return (Blog) blogRepository.findById(blogId).get();
    }

    @Override
    public List<Blog> getBlogList() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public User getAuthorDetails(String blogId) {
        User user = ((Blog)blogRepository.findById(blogId).get()).getUser();
        String userId = user.getUserId();
        return (User) userRepository.findById(userId).get();
    }

    @Override
    public boolean publishBlog(Blog blog) {
        blogRepository.save(blog);
        return true;
    }

    @Override
    public boolean updateBlog(Blog blog) {
        Blog updatedBlog = blogRepository.findById(blog.getBlogId()).get();
        if(blog.getImage()!=null)
            updatedBlog.setImage(blog.getImage());
        if(blog.getContent()!=null)
            updatedBlog.setContent(blog.getContent());
        blogRepository.save(updatedBlog);
        return true;
    }

    @Override
    public boolean deleteBlog(String blogId) {
        blogRepository.deleteById(blogId);
        return true;
    }
}
