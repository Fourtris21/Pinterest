package org.example.services;

import org.example.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PostService {

    private List<Post> posts = new ArrayList<>();

    public PostService() {
        // Initialize with some dummy data
        posts.add(new Post("Партита", "Изненада торта"));
        posts.add(new Post("Здравословни рецепти", "Варени картофи"));
        posts.add(new Post("Пости", "Веган"));
        posts.add(new Post("Дом", "Art in home"));
        posts.add(new Post("Дом", "Home interior"));
        posts.add(new Post("Котки", "Котка Турски Ван"));
    }

    public List<Post> getPostsByFolderName(String folderName) {
        return posts.stream()
                .filter(post -> post.getFolderName().equalsIgnoreCase(folderName))
                .collect(Collectors.toList());
    }

    public void addPost(String folderName, String postTitle) {
        posts.add(new Post(folderName, postTitle));
    }

    public List<Post> searchPostsByKeyword(String keyword) {
        if (keyword.trim().isEmpty()) {
            return posts;
        }
        return posts.stream()
                .filter(post -> post.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Post> getPostByName(String name) {
        return posts.stream().filter(post -> post.getTitle().equals(name)).findFirst();

    }
    public Set<Post> getAllPosts() {
        return posts.stream().map(post -> post).collect(Collectors.toSet());
    }

}