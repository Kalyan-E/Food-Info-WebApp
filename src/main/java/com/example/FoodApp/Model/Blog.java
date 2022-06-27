package com.example.FoodApp.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document(collation = "Blogs")
public class Blog {
        @Id
        private String id;
        private String title;
        private String description;
        private String category;
        private Location location;
        private String file;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Blog( String title, String description, String category, Location location, String file, LocalDateTime createdAt, LocalDateTime updatedAt) {
                this.title = title;
                this.description = description;
                this.category = category;
                this.location = location;
                this.file = file;
                this.createdAt = createdAt;
                this.updatedAt = updatedAt;
        }
}
