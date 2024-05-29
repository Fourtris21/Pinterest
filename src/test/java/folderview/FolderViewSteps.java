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

    @Given("the application is opened")
    public void the_application_is_opened() {
        // No specific implementation needed for this example
    }

    @Then("a list of all boards is displayed")
    public void a_list_of_all_folders_is_displayed() {
        folders = folderService.getAllFolders();
        Assert.assertNotNull(folders);
        Assert.assertFalse(folders.isEmpty());
    }

    @When("the user selects the folder named {string}")
    public void the_user_selects_the_folder_named(String folderName) {
        Optional<Folder> folder = folderService.getFolderByName(folderName);
        Assert.assertTrue(folder.isPresent());
    }

    @Then("the folder {string} is displayed with all its posts")
    public void the_folder_is_displayed_with_all_its_posts(String folderName) {
        Optional<Folder> folder = folderService.getFolderByName(folderName);
        Assert.assertTrue(folder.isPresent());
        Assert.assertFalse(folder.get().getPosts().isEmpty());
    }

    @When("the user enters the folder name {string} in the search field")
    public void the_user_enters_the_folder_name_in_the_search_field(String folderName) {
        folders = folderService.searchFoldersByName(folderName);
    }

    @When("clicks the search button")
    public void clicks_the_search_button() {
        // This step is handled by the searchBoardsByName method call
    }

    @Then("a list of folders matching {string} is displayed")
    public void a_list_of_folders_matching_is_displayed(String folderName) {
        Assert.assertNotNull(folders);
        Assert.assertFalse(folders.isEmpty());
    }

    @When("the user selects the category {string}")
    public void the_user_selects_the_category(String category) {
        // Category functionality not implemented in this example
    }

    @Then("a list of folders in the {string} category is displayed")
    public void a_list_of_folders_in_the_category_is_displayed(String category) {
        // Category functionality not implemented in this example
    }

    @When("the user enters {string} in the search field")
    public void the_user_enters_in_the_search_field(String keyword) {
        folders = folderService.searchFoldersByName(keyword);
    }

}
