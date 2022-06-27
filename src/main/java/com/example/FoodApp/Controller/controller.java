package com.example.FoodApp.Controller;

import com.example.FoodApp.Model.Blog;
import com.example.FoodApp.Service.Service;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class controller {

    private final Service service;
    @PostMapping
    public ResponseEntity addBlog(@RequestBody Blog blog) {
        service.addBlog(blog);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateBlog(@RequestBody Blog blog) {
        service.updateBlog(blog);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return ResponseEntity.ok(service.getAllBlogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity getBlogById(@PathVariable String id) {
        return ResponseEntity.ok(service.getBlog(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBlog(@PathVariable String id) {
        service.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }

}
