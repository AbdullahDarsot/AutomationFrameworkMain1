package utils.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.selenium.Driver.browser;
import static utils.selenium.Settings.weHighlightedColour;

public class WebElementHelpers {

    public WebDriverWait weWaitForSeconds() {
        int sec = 10;
        WebDriverWait wait = new WebDriverWait(browser(), sec);
        return wait;
    }

    public void weElementIsDisplayed(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.visibilityOf(element));
    }

    public void weElementToBeClickable(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void weHighlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) browser();
        js.executeScript(weHighlightedColour, element);
    }

    public void weClick(WebElement element) {
        weElementToBeClickable(element);
        weHighlightElement(element);
        element.click();
    }

    public void weSendKeys(WebElement element, String text, boolean clearFirst) {
        weElementIsDisplayed(element);
        if (clearFirst) weClick(element);
        element.sendKeys(text);
    }

    public void weElementIsInvisible(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.invisibilityOf(element));
    }

    public String weGetAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
}
