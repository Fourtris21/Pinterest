package postview;
import io.cucumber.java.en.*;
import org.example.models.Post;
import org.example.services.PostService;
import org.junit.Assert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class PostViewSteps {
    private PostService postService = new PostService();
    private List<Post> posts;
    private List<Post> postsSecondFilter;
    private Post helperPost;




    @Given("Приложението е отворено")
    public void the_application_is_opened() {
        // No specific implementation needed for this example
    }

    @When("Потребителят избира папка с име {string}")
    public void the_user_selects_the_folder_named_posts(String folderName) {
        posts = postService.getPostsByFolderName(folderName);
        assertFalse(posts.isEmpty());
    }

    @Then("Показва се лист с всички постове в папката {string}")
    public void a_list_of_all_pins_on_the_folder_is_displayed(String folderName) {
        posts = postService.getPostsByFolderName(folderName);
        assertFalse(posts.isEmpty());
    }

    @And("Потребителят клика на бутона за добавяне на пост")
    public void the_user_clicks_the_add_pin_button() {
        this.helperPost = new Post();

    }

    @And("Потребителят въвежда повече детайли за поста")
    public void the_user_provides_the_pin_details() {
        this.helperPost.setTitle("Изненада торта2");
        this.helperPost.setFolderName("Партита");
        postService.addPost(this.helperPost.getFolderName(), this.helperPost.getTitle());

    }

    @Then("Новият пост е добавен към папката {string}")
    public void the_new_pin_is_added_to_the_board(String folderName) {
        posts = postService.getPostsByFolderName(folderName);
        assertTrue(posts.stream().anyMatch(post -> post.getTitle().equals(this.helperPost.getTitle())));
    }

    @When("Потребителят въвежда {string} в полето за търсене")
    public void the_user_provides_keyword_in_search_bar(String keyword) {
        posts = postService.searchPostsByKeyword(keyword);
        Assert.assertNotNull(posts);
    }

    @And("Натиска бутона за търсене")
    public void the_user_clicks_the_search_button() {
        // No specific implementation needed for this example
    }

    @Then("Показва се лист от постове, отговарящи на {string}")
    public void a_list_of_pins_matching_is_displayed(String keyword) {
        for (Post post : posts) {
            Assert.assertTrue(post.getTitle().toLowerCase().contains(keyword.toLowerCase()));
        }
    }

    @When("the user selects a pin named {string}")
    public void the_user_selects_a_pin_named(String pinName) {
        // Select pin by name logic (if needed)
    }



    @When("the user chooses the board {string}")
    public void the_user_chooses_the_board(String boardName) {
        // No specific implementation needed for this example
    }

    @Then("the pin {string} is saved to the board {string}")
    public void the_pin_is_saved_to_the_board(String pinName, String boardName) {
        // Logic to verify the pin is saved to the board
    }


}
