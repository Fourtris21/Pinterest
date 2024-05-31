package org.example.services;

import org.example.models.Folder;
import org.example.models.Post;

import java.util.*;
import java.util.stream.Collectors;

public class FolderService {

    private List<Folder> folders = new ArrayList<>();
    private CategoryService categoryService = new CategoryService();
    private Set<Post> food_posts = new HashSet<>();
    private List<Folder> categoryFolders;

    public FolderService() {
        // Initialize with some dummy data
        folders.add(new Folder("Партита", categoryService.getCategoryById(1)));
        folders.add(new Folder("Здравословни рецепти", categoryService.getCategoryById(2)));
        folders.add(new Folder("Кучета", categoryService.getCategoryById(4)));
        folders.add(new Folder("Идеи за пътуване", categoryService.getCategoryById(1)));
        folders.add(new Folder("Ливански рецепти", categoryService.getCategoryById(2)));
        folders.add(new Folder("Декор за дома", categoryService.getCategoryById(3)));

        Post p1 = new Post("Фалафели");
        Post p2 = new Post("Хумус");
        food_posts.add(p1);
        food_posts.add(p2);

        folders.get(4).setPosts(food_posts);
    }

    public List<Folder> getAllFolders() {
        return folders;
    }

    public Optional<Folder> getFolderByName(String name) {
        return folders.stream()
                .filter(folder -> folder.getTitle().equalsIgnoreCase(name))
                .findFirst();
    }
    public Optional<Folder> getFromCategoryFolderByName(String name) {
        return categoryFolders.stream()
                .filter(folder -> folder.getTitle().equalsIgnoreCase(name))
                .findFirst();
    }
    public List<Folder> getFolderByCategory(String category) {
        return folders.stream().
                filter(folder -> folder.getCategory().getName().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Folder> searchFoldersByName(String name) {
        if (name.trim().isEmpty()) {
            return getAllFolders();
        }
        return folders.stream()
                .filter(folder -> folder.getTitle().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
    public void addPostToFolder(Folder folder, Post post) {
        Set<Post> posts = folder.getPosts();
        posts.add(post);
        folder.setPosts(posts);
        int index = folders.indexOf(folder);
        folders.set(index, folder);
    }
    public void setCategoryFolders(List<Folder> categoryFolders) {
        this.categoryFolders = categoryFolders;
    }

}
