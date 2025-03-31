package models;

import org.openqa.selenium.By;

public class HomePageModel {
    public static By acceptCookiesButton = By.xpath("//a[@id='wt-cli-accept-all-btn']");
    public static By homePageHeader = By.xpath("//h1[contains(text(),'Insider')]");
    public static By companyMenu = By.xpath("//span[text()='Company']");
    public static By careersLink = By.xpath("//a[text()='Careers']");
}
