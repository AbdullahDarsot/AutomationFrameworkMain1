package steps;

import cucumber.api.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BasePage;
import pages.Page;

public class BaseSteps extends Page {

    @Given("^(?:a DuckDuckGo user|an internet user) is on the (?:base|search) page$")
    public void userIsOnTheBasePage() {
        instanceOf(BasePage.class).navigateToBaseUrl();
    }

    @Then("^they see the page title contains \"([^\"]*)\"$")
    public void they_see_the_page_title_contains(String expectedTitle) {
        instanceOf(BasePage.class).validatePageTitle(expectedTitle);
    }
}