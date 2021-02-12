package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
   protected static WebDriver driver;
   protected static WebDriverWait wait;

   public void beforemethod() {

       System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
       driver = new ChromeDriver();
       wait = new WebDriverWait(driver,5000);
       driver.manage().window().maximize();
    }

    public void aftermethod() {

       driver.quit();

    }

}
