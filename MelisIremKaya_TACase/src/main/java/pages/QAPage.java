package pages;

import models.QAPageModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.ElementHelper;
import java.util.List;

public class QAPage {
    WebDriver driver;
    ElementHelper elementHelper;

    public QAPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    //Driver get QA Jobs url.
    public void openQaJobs() {

        driver.get("https://useinsider.com/careers/quality-assurance/");
    }

    //Click All QA Jobs Button.
    public void clickSeeAllJobs() {

        elementHelper.click(QAPageModel.btn_seeAllQAJobs);
    }

    //Takes the location by string and department by string, filter jobs using that parameters.
    public void filterJobs(String location, String department) {

        //Wait until 27 seconds. Because some have connection problems while loading site.
        try {
            Thread.sleep(27000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Click Locaion Filter Button
        elementHelper.click(QAPageModel.fltr_byLocation);
        ElementHelper.waitInSeconds(5);

        //Get location string and search element using string, when find, click
        WebElement locationOption = driver.findElement(By.xpath("//ul/li[text()='" + location + "']"));
        locationOption.click();
        ElementHelper.waitInSeconds(5);

        //Click Locaion Department Button
        elementHelper.click(QAPageModel.fltr_byDepartment);
        ElementHelper.waitInSeconds(5);

        //Get department string and search element using string, when find, click
        WebElement departmentDrop = driver.findElement(By.xpath("//ul/li[text()='" + department + "']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(departmentDrop).click().perform();
        ElementHelper.waitInSeconds(5);
    }


    //When we filter jobs, check expected results.
    public void checkJobsList() {

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> jobElements = driver.findElements(By.id("jobs-list"));
        if (!jobElements.isEmpty()) {
            System.out.println("Matching job listings found");

            for (WebElement job : jobElements) {
                System.out.println("Job title: " + job.getText());
            }
        } else {
            System.out.println("No jobs found for the selected criteria.");
        }
    }


    //Takes titles as a list and checks if they contain our keywords about the jobs. Keywords are QA and Quality
    public void checkJobTitle(String jobTitle1, String jobTitle2) {

        List<WebElement> elements = driver.findElements(By.xpath("//div[@data-team='qualityassurance' and @data-location='istanbul-turkey']/div/p"));
        for (int i = 0; i < elements.size(); i++) {
            String text = elements.get(i).getText();
            System.out.println(text);
            if (text.contains(jobTitle1) || text.contains(jobTitle2)) {
                System.out.println("Element " + (i + 1) + ": '" + text + "' contains keywords");
            } else {
                System.out.println("Element " + (i + 1) + ": '" + text + "' does not contain keywords");
            }
        }
    }

    //Takes departments as a list and checks if they are equal to departmentkeyword. departmenkeyword: Quailty Assurance
    public void checkDepartment(String department) {

        List<WebElement> elements = driver.findElements(By.xpath("//div[@data-team='qualityassurance' and @data-location='istanbul-turkey']/div/span"));
        for (int i = 0; i < elements.size(); i++) {
            String text = elements.get(i).getText();
            System.out.println(text);
            if (text.equals(department)) {
                System.out.println("Element " + (i + 1) + ": '" + text + "' Department correct");
            } else {
                System.out.println("Element " + (i + 1) + ": '" + text + "' Department incorrect");
            }
        }

    }

    //It takes Location elements' xpath as a list and checks if they are correct
    public void checkLocation(String location){

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='position-location text-large']"));
        for (int i = 0; i < elements.size(); i++) {
            String text = elements.get(i).getText();
            System.out.println(text);
            if (text.equals(location)) {
                System.out.println("Element " + (i + 1) + ": '" + text + "' Location correct");
            } else {
                System.out.println("Element " + (i + 1) + ": '" + text + "' Location incorrect");
            }
        }

    }
}
