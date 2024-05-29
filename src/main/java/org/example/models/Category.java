package org.example.models;

import java.util.Set;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long id;
    private String name;
    private Set<Post> posts;

    // Getters and Setters
    // ...
}
