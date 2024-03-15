package com.bfi.backend.admin.services;

import com.bfi.backend.admin.entities.Blogs;
import com.bfi.backend.admin.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService {
    private final BlogRepository blogRepository;
    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
    public List<Blogs> getAllBlogs() {
        return blogRepository.findAll();
    }


    public Blogs addBlog(Blogs blog) {
        return blogRepository.save(blog);
    }
}
