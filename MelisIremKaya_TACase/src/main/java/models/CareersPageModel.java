package models;

import org.openqa.selenium.By;

public class CareersPageModel {
   public static By btn_more = By.xpath("//a[@id='navbarDropdownMenuLink']");
   public static By btn_careers = By.xpath("//a[text()='Careers']");
   public static By hdr_teams = By.id("career-find-our-calling");
   public static By btn_teams = By.cssSelector("#career-find-our-calling h3");
   public static By hdr_locations = By.id("career-our-location");
   public static By btn_locations = By.cssSelector("#career-our-location p");
   public static By hdr_lifeAtInsider = By.xpath("//h2[text()='Life at Insider']");

}
