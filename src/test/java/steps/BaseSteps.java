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

    @Given("the user is logged in")
    public void userIsLoggedIn() {
        instanceOf(BasePage.class).navigateToBaseUrl();
        instanceOf(BasePage.class).enterUsername("abdullah.darsot@roq.co.uk");
        instanceOf(BasePage.class).clickContinue();
        instanceOf(BasePage.class).enterPassword("Trello123!");
        instanceOf(BasePage.class).delay();
        instanceOf(BasePage.class).clickLogin();
        instanceOf(BasePage.class).title();
    }

    @Then("the user clicks log out")
    public void theUserClicksLogOut() {
        instanceOf(BasePage.class).clickUserProfile();
        instanceOf(BasePage.class).clickLogOut();
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