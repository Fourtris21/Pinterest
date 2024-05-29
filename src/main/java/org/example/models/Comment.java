package org.example.models;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id;
    private String text;
    private Post post;
    private User user;

    // Getters and Setters
    // ...
}