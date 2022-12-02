package pages;

import static utils.selenium.Driver.browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.selenium.Settings;

public class BasePage extends Page {
    private String getTitle() { return driver.getTitle(); }

    public WebDriver driver = browser();

    public void navigateToBaseUrl() {
        String baseUrl = Settings.baseUrl;
        browser().navigate().to(baseUrl);
        System.out.println("Welcome to Product - Selenium Automation Framework");
    }

    public void validatePageTitle(String expectedTitle) {
        Assert.assertTrue(getTitle().contains(expectedTitle));
        System.out.println(":: The title of the site is: " + getTitle());
    }

}