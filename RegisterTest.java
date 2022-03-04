package HomeWorkTest;

import HomeWork.Basepage;
import HomeWork.Register;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class RegisterTest {
    Basepage basepage;
    Properties prop;
    Register register;

    @BeforeTest
    public void openbrowser(){
        basepage = new Basepage();
        prop = basepage.intialisePropertiesO();
        String browser = prop.getProperty("browser");

        WebDriver driver = basepage.intialiseDriver(browser);
        driver.get(prop.getProperty("url"));
         register = new Register(driver);

    }
    @Test(priority = 1)
    public  void verifygettitle() {
        Assert.assertEquals(register.getPageTitle(),"nopCommerce demo store. Login","Login title is not correct");
    }
    @Test(priority = 2)
    public void verifyregisterbutton(){
        Assert.assertTrue(register.verifyregisterbutton(),"Register link is not displayed");
    }
    @Test(priority = 3)
    public void clickregibutton(){
        register.clickRegbutton();
    }
    @Test(priority = 4)
    public void clickGender() {
        register.clickGender();
    }
    @Test(priority = 5)
   public void dofillName() throws InterruptedException {
        Thread.sleep(2000);
        register.fillName(prop.getProperty("fname"), prop.getProperty("lname") );
    }
    @Test(priority = 6)
    public void brithDetail(){
        register.fillBirthdetail(prop.getProperty("DateOfBirthDay"), prop.getProperty("DateOfBirthMonth"), prop.getProperty("DateOfBirthYear"));
    }
    @Test(priority = 7)
    public void emailid(){
        register.fillEmail(prop.getProperty("Email"));
    }
    @Test(priority = 8 )
    public void companyid(){
        register.companyName(prop.getProperty("Company"));
    }
    @Test(priority = 9)
    public void boxClick(){
        register.clickBox();
    }
    @Test(priority = 10)
    public void passwordFill(){
        register.fillPassword(prop.getProperty("Password"), prop.getProperty("ConfirmPassword"));
    }
    @Test(priority = 11 )
    public void clickRegbutton(){
        register.clickreg();
        
    }


    }



