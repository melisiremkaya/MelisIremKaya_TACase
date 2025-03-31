package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.ElementHelper;
import models.QAJobsDetailModel;

import java.util.Objects;

public class QAJobsDetailPage {
    WebDriver driver;
    ElementHelper elementHelper;

    public QAJobsDetailPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void clickViewRole() {
        //View Role button is hidden normally, this method perform the mouse on the element and when the see button than click.
        WebElement l=driver.findElement(By.xpath("(//h3[contains(text(),'Browse')])[1]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
        ElementHelper.waitInSeconds(1);

        WebElement firstJob = driver.findElement(By.xpath("//p[text()='Senior Software Quality Assurance Engineer']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstJob).perform();


        driver.findElement(QAJobsDetailModel.btn_viewRole).click();
        ElementHelper.waitInSeconds(10);
    }

    public boolean isRedirectedToLever() {
        //When we swtich the Lever tab, close Switch Tab and check the correct url.
        ElementHelper.closeInsiderPageSwitchTab();
        ElementHelper.waitInSeconds(3);
        return driver.getCurrentUrl().contains("lever.co");
    }
}
