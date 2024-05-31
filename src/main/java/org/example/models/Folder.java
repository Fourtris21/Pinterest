package org.example.models;

import java.util.HashSet;
import java.util.Set;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Folder {
    private Long id;
    private String title;
    private User user;
    private Set<Post> posts;
    private Category category;

    public Folder(String title, Category category) {
        this.title = title;
        this.posts = new HashSet<>();
        this.category = category;
    }
}