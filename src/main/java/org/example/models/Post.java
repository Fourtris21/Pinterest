package org.example.models;

import java.util.Date;
import java.util.Set;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String description;
    private int likes;
    private int savings;
    private Date createdAt;
    private User user;
    private String folderName;
    private Set<Comment> comments;
    private Set<Category> categories;

    public Post(String folderName, String title) {
        this.folderName = folderName;
        this.title = title;
        this.description = "";
    }
}