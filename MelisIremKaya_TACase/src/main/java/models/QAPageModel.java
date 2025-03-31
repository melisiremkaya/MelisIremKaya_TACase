package models;

import org.openqa.selenium.By;

public class QAPageModel {
    public static By btn_seeAllQAJobs = By.xpath("//a[text()='See all QA jobs']");
    public static By fltr_byLocation = By.xpath("//span[@title='All']");
    public static By fltr_byDepartment = By.xpath("//select[@name='filter-by-department']/parent::div/child::span/span[@class='selection']");
}
