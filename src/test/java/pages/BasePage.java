package pages;

import static utils.selenium.Driver.browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.helpers.WebDriverHelpers;
import utils.helpers.WebElementHelpers;
import utils.selenium.Settings;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends Page {
    @FindBy(xpath = "//*[@id=\"user\"]")
    public WebElement enterUsername;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement enterPassword;

    @FindBy(xpath = "//*[@id=\"login\"]")
    public WebElement clickNext;

    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    public WebElement clickLogin;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div/div[1]/h3")
    public WebElement title;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div[5]/button")
    public WebElement clickUserProfile;

    @FindBy(xpath = "/html/body/div[3]/div/section/div/nav/ul/li[11]/button")
    public WebElement clickLogOut;

    private String getTitle() { return driver.getTitle(); }
    private String getUrl() {return driver.getCurrentUrl(); }
    private String getPageSource() {return driver.getPageSource(); }
    protected WebElementHelpers elementHelpers = new WebElementHelpers();
    protected WebDriverHelpers driverHelpers = new WebDriverHelpers();

    public WebDriver driver = browser();



    public void navigateToBaseUrl() {
        String baseUrl = Settings.baseUrl;
        browser().navigate().to(baseUrl);
        System.out.println("Welcome to Product - Selenium Automation Framework");
    }


    public void enterUsername(String searchTerm){
        elementHelpers.weSendKeys(enterUsername,searchTerm,true);
        instanceOf(BasePage.class);
    }

    public void clickContinue(){
        elementHelpers.weClick(clickNext);
        instanceOf(BasePage.class);
    }



    public void enterPassword(String searchTerm){
        elementHelpers.weSendKeys(enterPassword,searchTerm,true);
        instanceOf(BasePage.class);
    }

    public void delay(){
        elementHelpers.weWaitForSeconds();
    }

    public void clickLogin() {
        elementHelpers.weClick(clickLogin);
        instanceOf(BasePage.class);
    }

    public void title() {
        elementHelpers.weElementIsDisplayed(title);
        instanceOf(BasePage.class);
    }

    public void clickUserProfile() {
        elementHelpers.weClick(clickUserProfile);
        instanceOf(BasePage.class);
    }

    public void clickLogOut() {
        elementHelpers.weClick(clickLogOut);
        instanceOf(BasePage.class);
    }

    public void validatePageTitle(String expectedTitle) {
        Assert.assertTrue(getTitle().contains(expectedTitle));
        System.out.println(":: The title of the site is: " + getTitle());
    }

    public void validatePageUrl(String expectedUrl) {
        Assert.assertTrue(getUrl().contains(expectedUrl));
        System.out.println(":: The page Url is: " + getUrl());
    }
    public void validatePageSource(String expectedPageSource) {
        Assert.assertTrue(getPageSource().contains(expectedPageSource));
        System.out.println(":: The page source is: " + getPageSource());
    }

    public void validateMultipleInPageSource(List<String> table) {
        for (String row : table) {
            Assert.assertTrue(getPageSource().contains(row));
            System.out.println("The text " + row + " is in the PageSource");
        }
    }
}