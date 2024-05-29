package org.example.services;

import org.example.models.Folder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FolderService {

    private List<Folder> folders = new ArrayList<>();

    public FolderService() {
        // Initialize with some dummy data
        folders.add(new Folder("Партита"));
        folders.add(new Folder("Здравословни рецепти"));
        folders.add(new Folder("Кучета"));
        folders.add(new Folder("Идеи за пътуване"));
        folders.add(new Folder("Ливански рецепти"));
        folders.add(new Folder("Декор за дома"));
    }

    public List<Folder> getAllFolders() {
        return folders;
    }

    public Optional<Folder> getFolderByName(String name) {
        return folders.stream()
                .filter(folder -> folder.getTitle().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Folder> searchFoldersByName(String name) {
        if (name.trim().isEmpty()) {
            return getAllFolders();
        }
        return folders.stream()
                .filter(folder -> folder.getTitle().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
