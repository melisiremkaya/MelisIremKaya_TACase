package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import utils.DriverFactory;
import utils.ElementHelper;
import pages.HomePage;
import pages.CareersPage;
import pages.QAJobsDetailPage;
import pages.QAPage;

import static org.testng.Assert.assertTrue;

public class InsiderTest {
    WebDriver driver;
    ElementHelper elementHelper;
    static HomePage homePage;
    static CareersPage careerPage;
    static QAPage qaPage;
    static QAJobsDetailPage qaJobsDetailPage;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.initializeDriver("chrome");
        homePage = new HomePage(driver);
        careerPage = new CareersPage(driver);
        qaPage = new QAPage(driver);
        qaJobsDetailPage = new QAJobsDetailPage(driver);
        driver.get("https://useinsider.com/");
    }

    @Test(priority = 0)
    public void testInsiderHomePage() {
        homePage.openHomePage();
        Assert.assertTrue(homePage.isHomePageOpened(),"Home page is not opened");
    }


    @Test(priority = 1)
    public void GoToCareerPageAndValidate(){
        // Go to career page and validate sections
        careerPage.openCareersPage();
        Assert.assertTrue(careerPage.isCareersPageOpened(),"Careers page is not opened");
        careerPage.checkCareerSections();

    }

    @Test(priority = 2)
    public void GoToQaJobsAndFilter(){
        // Open QA Jobs filter using parameters than check expected results.
        qaPage.openQaJobs();
        qaPage.clickSeeAllJobs();
        qaPage.filterJobs("Istanbul, Turkiye","Quality Assurance");
        qaPage.checkJobsList();
    }
    @Test(priority = 3)
    public void ValidateFilteredJobs(){
        // Validate filtered Jobs using parameters.
        qaPage.checkJobTitle("QA", "Quality Assurance");
        qaPage.checkDepartment("Quality Assurance");
        qaPage.checkLocation("Istanbul, Turkey");

    }
    @Test(priority = 4)
    public void GoToTheApplicationSiteAndValidate(){
        // Open Application Site by Click View Role
        qaJobsDetailPage.clickViewRole();
        Assert.assertTrue(qaJobsDetailPage.isRedirectedToLever(),"Lever site is not open");}

    @AfterClass
    public void teardown() {
        // for closing browser
        driver.quit();
    }
}
