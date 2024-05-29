package org.example.models;

import java.util.Set;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String username;
    private String email;
    private String phone;
    private String password;
    private Set<Post> posts;
    private Set<Comment> comments;
    private Set<User> followings;
    private Set<User> followers;
    private Set<Conversation> conversations;

    // Getters and Setters
    // ...
}