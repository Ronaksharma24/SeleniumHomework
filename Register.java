package HomeWork;

import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
    WebDriver driver;
    Utils util;
    By registericon = By.className("ico-register");
   By gender= By.id("gender-male");
   By firstname = By.id("FirstName");
   By lastname = By.id("LastName");
   By Dob =  By.name("DateOfBirthDay");
   By DOM  = By.name("DateOfBirthMonth");
   By DOY = By.name("DateOfBirthYear");
   By emailid = By.id("Email");
   By companyname =By.id("Company");
   By NLcheckbox = By.id("Newsletter");
   By password = By.id("Password");
   By pwd = By.id("ConfirmPassword");
   By regibutton = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button");
   By subregbutton = By.id("register-button");

   public Register(WebDriver driver){
       this.driver = driver;
        util = new Utils(driver);
   }
   public String getPageTitle(){
       String title = driver.getTitle();
       System.out.println("Login page title is "+ title);
       return title;
   }
   public boolean verifyregisterbutton(){
       return driver.findElement(registericon).isDisplayed();
   }
   public void clickRegbutton(){
       driver.findElement(regibutton).click();
   }
   public  void clickGender(){
       driver.findElement(gender).click();
   }



   public String doregister(String property){
       driver.findElement(subregbutton).click();

       driver.findElement(regibutton).click();
       driver.findElement(gender).click();
       driver.findElement(firstname).sendKeys("fname");
       driver.findElement(lastname).sendKeys("lname");
       driver.findElement(Dob).sendKeys("DateOfBirthday ");
       driver.findElement(DOM).sendKeys("DateOfBirthMonth ");
       driver.findElement(DOY).sendKeys("DateOfBirthYear");
       driver.findElement(emailid).sendKeys("Email");
       driver.findElement(companyname).sendKeys("company");
       driver.findElement(NLcheckbox).click();
       driver.findElement(password).sendKeys("Password");
       driver.findElement(pwd).sendKeys("Confirmpassword");
       return property;
   }
   public void fillName(String name1,String name2){
       driver.findElement(firstname).sendKeys(name1);
       driver.findElement(lastname).sendKeys(name2);
   }
   public void fillBirthdetail(String dob,String dom, String doy){
       driver.findElement(Dob).sendKeys(dob);
       driver.findElement(DOM).sendKeys(dom);
       driver.findElement(DOY).sendKeys(doy);
   }
   public void fillEmail(String email){
       driver.findElement(emailid).sendKeys(email);
   }
   public void companyName(String compname){
       driver.findElement(companyname).sendKeys(compname);
   }
   public void clickBox(){
       driver.findElement(NLcheckbox).click();
   }
   public void fillPassword(String p1,String p2){
       driver.findElement(password).sendKeys(p1);
       driver.findElement(pwd).sendKeys(p2);
   }
   public void clickreg(){
       driver.findElement(subregbutton).click();
       driver.quit();
   }

}

