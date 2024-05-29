package org.example.models;

import java.util.Date;
import java.util.Set;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conversation {
    private Long id;
    private Date createdAt;
    private Set<User> participants;
    private Set<Message> messages;

    // Getters and Setters
    // ...
}
