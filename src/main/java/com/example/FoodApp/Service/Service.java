package com.example.FoodApp.Service;

import com.example.FoodApp.Model.Blog;
import com.example.FoodApp.Repo.Repo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Transactional
public class Service {

    private final Repo repo;
    public void addBlog(Blog blog) {
        repo.insert(blog);
    }

    public void updateBlog(Blog blog) {
        Blog savedBlog = repo.findById(blog.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Blog by ID %s", blog.getId())));
        savedBlog.setTitle(blog.getTitle());
        savedBlog.setDescription(blog.getDescription());
        savedBlog.setCategory(blog.getCategory());
        savedBlog.setLocation(blog.getLocation());

        repo.save(blog);
    }

    public Blog getBlog(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Blog by id - %s", id)));
    }

    public List<Blog> getAllBlogs() {
        return repo.findAll();
    }

    public void deleteBlog(String id) {
        repo.deleteById(id);
    }
}
