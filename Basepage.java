package HomeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Basepage {

    WebDriver driver;
    Properties prop;


    public WebDriver intialiseDriver(String browsename){
        if (browsename.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\shrm_\\IdeaProjects\\POMFramework\\src\\test\\resources\\TestData\\BrowserDriver\\chromedriver.exe");
             driver = new ChromeDriver();
        }else if (browsename.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","C:\\Users\\shrm_\\IdeaProjects\\POMFramework\\src\\test\\resources\\TestData\\BrowserDriver\\geckodriver.exe");
             driver = new FirefoxDriver();
        }else if (browsename.equals("edge")){
            System.setProperty("webdriver.edge.driver","C:\\Users\\shrm_\\IdeaProjects\\POMFramework\\src\\test\\resources\\TestData\\BrowserDriver\\msedgedriver.exe");
            driver = new EdgeDriver();
        }else if (browsename.equals("opera")){
            System.setProperty("webdriver.opera.driver","C:\\Users\\shrm_\\IdeaProjects\\POMFramework\\src\\test\\resources\\TestData\\BrowserDriver\\operadriver.exe");
            driver = new OperaDriver();

        }else {
            System.out.println(browsename + "Browser is invaild,please enter correct browser name ");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }
    public Properties intialisePropertiesO(){
        prop  = new Properties();

        try {
            FileInputStream ip = new FileInputStream("C:\\Users\\shrm_\\IdeaProjects\\POMFramework\\src\\" +
                    "test\\resources\\TestData\\config.properties.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            System.out.println("Config file is missing, please check....");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Properties cloud not be loaded....");
            e.printStackTrace();
        }
        return prop;
    }

}
