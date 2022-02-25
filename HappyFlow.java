package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HappyFlow {
    WebDriver driver;

    @BeforeClass
    void openbrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test(priority = 1)
    void selectItem() {
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[1]/div[2]/ul/li[1]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]")).click();
        assertEquals("The product been added to your shopping cart", "The product been added to your shopping cart");
    }

    @Test(priority = 2)
    void shoppingcart() {
        driver.findElement(By.className("cart-label")).click();
        driver.findElement(By.className("qty-input")).clear();
        driver.findElement(By.className("qty-input")).sendKeys("3");
    }

    @Test(priority = 3)
    void checkout() {
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
    }

    @Test(priority = 4)
    void guestcheckout() {
        driver.findElement(By.className("checkout-as-guest-button")).click();
    }

    @Test(priority = 5)
    void billing() {
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Sanj");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("shar");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("Testing@yahoo.com");
        driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("unifytesting");
    }

    @Test(priority = 6)
    void droplist() {
        WebElement ddlist = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select = new Select(ddlist);
        select.selectByVisibleText("United Kingdom");
    }

    @Test(priority = 7)
    void city() {
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("121 London Road");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("LO1 1LO");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("07788995511");
        driver.findElement(By.className("new-address-next-step-button")).click();

    }
    @Test(priority = 8)
    void shipping() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.className("shipping-method-next-step-button")).click();
    }
    @Test(priority = 9)
    void payment() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("paymentmethod_0")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button")).click();
    }
    @Test(priority = 10)
    void confirm() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button")).click();
    }
    @AfterClass
    void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
   /* @Test(priority = 10)
    void paymentdetail() throws InterruptedException {
        Thread.sleep(2000);
        WebElement droplist = driver.findElement(By.className("dropdownlists"));
        Select select = new Select(droplist);
        select.selectByVisibleText("Master card");
        driver.findElement(By.id("CardholderName")).sendKeys("Rcash");
        driver.findElement(By.id("CardNumber")).sendKeys("1234567891234567891234");
        Thread.sleep(2000);
        WebElement date = driver.findElement(By.id("ExpireMonth"));
        Select sel= new Select(date);
        sel.selectByVisibleText("01");
        Thread.sleep(2000);
        WebElement year= driver.findElement(By.id("ExpireYear"));
        Select sel1 = new Select(year);
        sel1.selectByVisibleText("2025");
        Thread.sleep(2000);
        driver.findElement(By.id("CardCode")).sendKeys("128");
        Thread.sleep(2000);
       driver.findElement(By.className("payment-info-next-step-button")).click();*/


    }








