package com.example.FoodApp.Repo;

import com.example.FoodApp.Model.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends MongoRepository<Blog,String> {
}
