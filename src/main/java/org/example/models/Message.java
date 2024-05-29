package org.example.models;

import java.util.Date;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Long id;
    private String text;
    private boolean read;
    private Date createdAt;
    private User user;
    private Conversation conversation;

    // Getters and Setters
    // ...
}