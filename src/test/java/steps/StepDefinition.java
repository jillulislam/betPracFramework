package steps;
import configuration.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pFactory.Header;
import pFactory.ScoreAndFixture;
import pFactory.SignInPage;
import pFactory.Sports;

public class StepDefinition extends BaseClass {

    ScoreAndFixture scoreAndFixture = new ScoreAndFixture(driver);
    Header header = new Header(driver);
    SignInPage signInPage = new SignInPage(driver);
    Sports sports = new Sports(driver);

    @Before
    public void launchTheBrowser() {
        chromeBrowser();
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

    @Given("User is on Score & Fixture page")
    public void user_is_on_score_fixture_page() {
        driver.get("https://www.bbc.co.uk/sport/football/scores-fixtures");
        scoreAndFixture = new ScoreAndFixture(driver);
        scoreAndFixture.clickOnYes();
    }

    @Then("I will record all the teams names who is playing today")
    public void i_will_record_all_the_teams_names_who_is_playing_today() {
        int teamSize = scoreAndFixture.teams.size();
        String[] teamName = new String[teamSize];
        if (scoreAndFixture.teams.isEmpty()) {
            System.out.println("No Match today");
        } else {
            for (int i = 0; i < teamSize; i++) {
                teamName[i] = scoreAndFixture.teams.get(i).getText();
            }
            for (String teamName1 : teamName){
                System.out.println(teamName1);
            }
        }
    }

    @When("^User enter sports in the search box$")
    public void user_enter_sports_in_the_search_box() {
        scoreAndFixture.enterSportsInTheSearchBox();
    }

    @And("^click on Search$")
    public void click_on_search(){
        scoreAndFixture.clickOnSearch();
    }

    @Then("^first and last heading should be displayed$")
    public void first_and_last_heading_should_be_displayed() {
        sports = new Sports(driver);
        sports.printFirstAndLastArticleHeadLines();
    }

    @When("^User click on sign In$")
    public void user_click_on_sign_in() {
        header = new Header(driver);
        header.clickOnSignIn();
    }

    @And("^Enter an incorrect (.*) and (.*)$")
    public void enter_an_incorrect_and(String username, String password) {
        signInPage = new SignInPage(driver);
        signInPage.email_field.sendKeys(username);
        signInPage.password_field.sendKeys(password);
    }

    @Then("^Error (.+) should be displayed$")
    public void error_should_be_displayed(String message) {
        Assert.assertEquals(message,signInPage.getInvalidText());
    }

    @And("^Click on sign in button$")
    public void click_on_sign_in_button(){
        signInPage.clickOnSubmitButton();
    }
}
