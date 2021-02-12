package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CardPage {

    WebDriver driver;

    By quantitySelect=By.xpath("//div[@class=\"gg-input gg-input-select \"]/select");
    By byRemoveProduct = By.xpath("//*[@class='gg-icon gg-icon-bin-medium']");

    public CardPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    public void AddQuantity(){
        try {
        Select selectObject = new Select(driver.findElement(quantitySelect));
        selectObject.selectByVisibleText("2");
        Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String QuantityControl(){
        Select selectObject = new Select(driver.findElement(quantitySelect));
        WebElement option = selectObject.getFirstSelectedOption();
        String control = option.getAttribute("value");
        return control;
    }

    public void basketProductRemove(){
        try {
            driver.findElement(byRemoveProduct).click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String productRemoveControl(){
        String control = driver.findElement(By.xpath("//*[@id='empty-cart-container']/div[1]/div[1]/div/div[2]/h2")).getText();
        return control;
    }
}