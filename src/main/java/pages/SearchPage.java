package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class SearchPage {

    WebDriver driver;

    By searchinput=By.xpath("//input[@placeholder='Evde Kal Sağlıklı Kal']");
    By searchButton=By.xpath("//button[@class='qjixn8-0 sc-1bydi5r-0 hKfdXF']");
    By secondPageButton=By.xpath("//div[@class='pager pt30 hidden-m gg-d-24']//a[text()='2']");

    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public WebElement searchInput()
    {
        return driver.findElement (searchinput);
    }

    public WebElement searchButton()
    {
        return driver.findElement (searchButton);
    }

    public void SecondPage()
    {
        try {
            ((JavascriptExecutor) driver)
                    .executeScript("window.scrollTo(0, document.body.scrollHeight)");

            WebElement secondPage = driver.findElement(secondPageButton);
            secondPage.click();
            Thread.sleep(1000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
