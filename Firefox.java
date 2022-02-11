package seleniumhomeworkweek1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\shrm_\\IdeaProjects\\software\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("testingselenium22@yahoo.com");
        driver.findElement(By.id("Password")).sendKeys("joylucky@77");
        driver.findElement(By.className("login-button")).click();

        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        driver.quit();


    }
}
