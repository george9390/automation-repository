//package utils;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class BaseTest {
//
//    public static WebDriver driver;
//
//    public static void launchBrowser() {
//
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//
//    public static void closeBrowser() {
//
//        if(driver != null) {
//            driver.quit();
//        }
//    }
//}




package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest {

    public static WebDriver driver;
	
    public static Properties prop;

    public static void launchBrowser() throws IOException {

        

        FileInputStream fis =
                new FileInputStream("src/test/resources/config.properties");
        prop = new Properties();
        prop.load(fis);

        String browser = prop.getProperty("browser");

        if(browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if(browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    

    public static String getProperty(String key) {

        return prop.getProperty(key);
    }
}