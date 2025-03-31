package pages;

import models.HomePageModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementHelper;

import java.util.Objects;


public class HomePage {

    ElementHelper elementHelper;
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void openHomePage() {
        //Open Insider Home Page
        driver.get("https://useinsider.com/");
        ElementHelper.waitInSeconds(3);
        elementHelper.click(HomePageModel.acceptCookiesButton);
        ElementHelper.waitInSeconds(3);
    }

    public boolean isHomePageOpened() {
        //Check the title contains insider.
        return driver.getTitle().contains("Insider");
    }

}
