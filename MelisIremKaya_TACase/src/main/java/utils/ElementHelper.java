package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ElementHelper {
    public static WebDriver driver;
    public WebDriverWait wait;

    // Constructor: Initializes the WebDriver and sets up an explicit wait of 10 seconds.
    public ElementHelper(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Finds a single web element based on the provided locator and waits until it is present.
    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Finds a web element and clicks it.
    public void click(By locator) {

        findElement(locator).click();

    }

    // Finds multiple web elements based on the provided locator and waits until they are all present.
    public List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    // Finds elements by locator, checks if their text matches the provided text, and clicks the matching element.
    public void clickElementWithText(By locator, String text) {
        boolean check = false;
        List<WebElement> elementList = findElements(locator);
        for (WebElement elem : elementList) {
            if (elem.getText().equals(text)) {
                check = true;
                elem.click();
                break;
            }
        }
        Assert.assertTrue(check, "Couldn't find the person in the text you wanted on the list!!!");
    }

    // Checks if the current URL matches the expected text exactly.
    public void checkUrl(String text){
        String actualURL = driver.getCurrentUrl();

        if (actualURL.equals(text)) {
            System.out.println("Current url value matches expected url value.");
        } else {
            System.out.println("Failure: Current url value did not match expected url value!");
        }

    }

    // Checks if the current URL starts with the expected base URL.
    public void checkBaseUrl(String text){
        String actualURL = driver.getCurrentUrl();

        if (actualURL.startsWith(text)) {
            System.out.println("Current url value matches expected url value.");
        } else {
            System.out.println("Failure: Current url value did not match expected url value!");
        }

    }

    // Finds an element and checks if it's present.
    public void checkElement(By locator) {
        findElement(locator);
    }


    // Finds multiple elements by locator and checks if their text contains the provided text for all of them.
    public void checkElementWithText(By locator, String text) {
        int i = 0;
        boolean check = false;
        findElement(locator);
        List<WebElement> elementList = findElements(locator);
        for (WebElement elem : elementList) {
            if (elem.getText().equals(text)) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check, "Couldn't find the person in the text you wanted on the list!!!");
    }


    // Finds elements by locator, checks if one of them has the provided text, and asserts if it's not found.
    public void checkElementsWithText(By locator, String text) {
        int i = 0;
        boolean check = true;
        List<WebElement> elementList = findElements(locator);
        for (WebElement elem : elementList) {
            if (!elem.getText().contains(text)) {
                check = false;
                break;
            }
        }
        Assert.assertTrue(check, "The value returned could not match all of the values in the list.");
    }


    // Waits for a specified number of seconds
    public static void waitInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
            System.out.println("Waiting for "+seconds+ " seconds");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Sleep interrupted", e);
        }
    }



    //When we click the View Role button, it redirects us to the Lever site but insider page keeps open. It closes the Insider tab and keeps the Lever site open.
    public static void closeInsiderPageSwitchTab(){

        Set<String> windowHandles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(windowHandles);
        driver.switchTo().window(handlesList.get(0));
        driver.close();
        driver.switchTo().window(handlesList.get(1));

    }

}
