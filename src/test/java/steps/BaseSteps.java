package steps;

import cucumber.api.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BasePage;
import pages.Page;
import java.util.List;

public class BaseSteps extends Page {

    @Given("^(?:a DuckDuckGo user|an internet user) is on the (?:base|search) page$")
    public void userIsOnTheBasePage() {
        instanceOf(BasePage.class).navigateToBaseUrl();
    }

    @Then("^they see the page title contains \"([^\"]*)\"$")
    public void they_see_the_page_title_contains(String expectedTitle) {
        instanceOf(BasePage.class).validatePageTitle(expectedTitle);
    }

    @Then("^they see the page Url contains \"([^\"]*)\"$")
    public void theySeeThePageUrlContains(String expectedUrl) {
        instanceOf(BasePage.class).validatePageUrl(expectedUrl);
    }

    @Then("^I see \"([^\"]*)\" in the PageSource$")
    public void iSeeInThePageSource(String expectedText) {
        String expectedPageSource = new String();
        instanceOf(BasePage.class).validatePageSource(expectedPageSource);
    }

    @Then("they see {string} in the PageSource")
    public void theySeeInThePageSource(String arg0) {
        String expectedPageSource = new String();
        instanceOf(BasePage.class).validatePageSource(expectedPageSource);
    }

    @Then("^they see$")
    public void theySee(List<String> existsInPageSource) {
        instanceOf(BasePage.class).validateMultipleInPageSource(existsInPageSource);
    }
}