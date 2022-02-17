package seleniumhomeworkweek2;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Registration {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(2000);

        driver.findElement(By.className("ico-register")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("gender-male")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("FirstName")).sendKeys("Ronak");
        driver.findElement(By.id("LastName")).sendKeys("Sharma");
        Thread.sleep(1000);
      //  driver.findElement(By.name("DateOfBirthDay")).sendKeys("24");
       // driver.findElement(By.name("DateOfBirthMonth")).sendKeys("February");
        //driver.findElement(By.name("DateOfBirthYear")).sendKeys("1981");
        WebElement day = driver.findElement(By.name("DateOfBirthDay"));
        WebElement month =driver.findElement(By.name("DateOfBirthMonth"));
        WebElement year = driver.findElement(By.name("DateOfBirthYear"));

        selectvaluefromdropdown(day,"14");
        selectvaluefromdropdown(month,"February");
        selectvaluefromdropdown(year,"1981");
        Thread.sleep(1000);
        driver.findElement(By.id("Email")).sendKeys("shrm_roank@yahoo.co.uk");
        driver.findElement(By.id("Company")).sendKeys("Unify Testing");
        driver.findElement(By.id("Newsletter")).click();
        driver.findElement(By.id("Password")).sendKeys("Testing123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Testing123");
        driver.findElement(By.name("register-button")).submit();

        driver.quit();



    }

    public static void selectvaluefromdropdown(WebElement element, String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
}
