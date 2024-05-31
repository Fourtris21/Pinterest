package folderview;

import io.cucumber.java.en.*;
import org.example.models.Folder;
import org.example.services.FolderService;
import org.junit.Assert;

import java.util.List;
import java.util.Optional;

public class FolderViewSteps {

    private FolderService folderService = new FolderService();
    private List<Folder> folders;
    private String category_name;


    @Given("Приложението е отворено")
    public void the_application_is_opened() {
        // No specific implementation needed for this example
    }

    @Then("Показва се лист с всички папки")
    public void a_list_of_all_folders_is_displayed() {
        folders = folderService.getAllFolders();
        Assert.assertNotNull(folders);
        Assert.assertFalse(folders.isEmpty());
    }

    @When("Показва се лист с всички папки от категория {string}")
    public void the_user_selects_the_folder_named(String categoryName) {
        List<Folder> categoryFolders = folderService.getFolderByCategory(categoryName);
        folderService.setCategoryFolders(categoryFolders);
        Assert.assertNotNull(categoryFolders);
    }

    @Then("Папката {string} се показва с всичките си постове")
    public void the_folder_is_displayed_with_all_its_posts(String folderName) {
        Optional<Folder> folder = folderService.getFromCategoryFolderByName(folderName);
        Assert.assertTrue(folder.isPresent());
        Assert.assertFalse(folder.get().getPosts().isEmpty());
    }

    @When("Потребителят въвежда {string} в полето за търсене")
    public void the_user_enters_the_folder_name_in_the_search_field(String folderName) {
        folders = folderService.searchFoldersByName(folderName);
    }

    @And("Натиска бутона за търсене")
    public void clicks_the_search_button() {
        // This step is handled by the searchBoardsByName method call
    }

    @Then("Показва се лист от папки, отговарящи на {string}")
    public void a_list_of_folders_matching_is_displayed(String folderName) {
        Assert.assertNotNull(folders);
        Assert.assertFalse(folders.isEmpty());
    }

    @When("Потребителят избира категория {string}")
    public void the_user_selects_the_category(String category) {
        this.category_name = category;
    }

    @Then("Показва се лист от папки от категорията")
    public void a_list_of_folders_in_the_category_is_displayed() {
        folders = folderService.getFolderByCategory(this.category_name);
        Assert.assertNotNull(folders);
    }

    @When("Потребителят въвежда ключова дума {string} в полето за търсене")
    public void the_user_enters_in_the_search_field(String keyword) {
        folders = folderService.searchFoldersByName(keyword);
    }

}
