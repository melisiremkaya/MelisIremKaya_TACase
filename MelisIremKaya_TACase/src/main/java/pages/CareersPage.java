package pages;

import models.CareersPageModel;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

import java.util.Objects;

public class CareersPage {

    WebDriver driver;
    ElementHelper elementHelper;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void openCareersPage() {
        //Open Careers page and check url
        elementHelper.clickElementWithText(CareersPageModel.btn_more,"Company");
        elementHelper.click(CareersPageModel.btn_careers);
        elementHelper.checkUrl("https://useinsider.com/careers/");
    }

    public boolean isCareersPageOpened() {
        //Check the careers title
        return Objects.requireNonNull(driver.getTitle()).contains("Careers");
    }

    public void checkCareerSections() {
        //Check the sections
        elementHelper.checkElement(CareersPageModel.hdr_locations);
        elementHelper.checkElementWithText(CareersPageModel.btn_locations,"London");
        elementHelper.checkElement(CareersPageModel.hdr_teams);
        elementHelper.checkElementWithText(CareersPageModel.btn_teams,"Sales");
        elementHelper.checkElement(CareersPageModel.hdr_lifeAtInsider);
    }
}
