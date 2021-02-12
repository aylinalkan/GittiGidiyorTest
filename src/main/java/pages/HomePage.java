package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage {

   WebDriver driver;


    public HomePage(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(this.driver,this);
    }

    public void gotoHome(){
        driver.get("https://www.gittigidiyor.com/");
    }

}
