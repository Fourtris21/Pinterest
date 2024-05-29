package org.example.models;

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

    public Folder(String title) {
        this.title = title;
    }
}