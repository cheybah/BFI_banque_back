package com.bfi.backend.admin.controllers;

import com.bfi.backend.admin.entities.Blogs;
import com.bfi.backend.admin.services.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class BlogController {

    private final BlogService blogService;

    // Endpoint pour récupérer tous les blogs
    @GetMapping("/blogs")
    public ResponseEntity<List<Blogs>> getAllBlogs() {
        List<Blogs> blogs = blogService.getAllBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    // Endpoint pour ajouter un nouveau blog
    @PostMapping("/addblog")
    public ResponseEntity<Blogs> addBlog(@RequestBody Blogs blog) {
        Blogs newBlog = blogService.addBlog(blog);
        return new ResponseEntity<>(newBlog, HttpStatus.CREATED);
    }
}