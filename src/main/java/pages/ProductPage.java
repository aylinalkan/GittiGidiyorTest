package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Random;

public class ProductPage {

    WebDriver driver;

    private static String productPrice;
    private static String basketPrice;

    By gotobasketButton = By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]");
    By bybasketProductPrice = By.xpath("//div[@class='total-price']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getProductPrice()
    {
        return productPrice;
    }
    public String getBasketPrice()
    {
        return basketPrice;
    }


    public void chooseProduct(){

        try {
            //Sayfadaki ürün sayısına kadar random sayı üretilir.
            int randomProductIndex = new Random().nextInt(48);
            //Rastgele bir ürün seçilir.
            WebElement productElement = driver.findElement(By.cssSelector(".products-container > li:nth-child(" + randomProductIndex + ")"));
            productElement.findElement(By.cssSelector("a")).click();
            Thread.sleep(4000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addToBasket(){
        try {
        WebElement addToBasketButton = driver.findElement(By.id("add-to-basket"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", addToBasketButton);
        addToBasketButton.click();
        Thread.sleep(1000);

            String pricehigh=driver.findElement(By.xpath("//*[@id='sp-price-highPrice']")).getText();
            String pricelow=driver.findElement(By.xpath("//*[@id='sp-price-lowPrice']")).getText();

            if (pricelow.isEmpty())
            {
                productPrice=pricehigh;
            }
            else
            {
                productPrice=pricelow;
            }

        }
        catch (InterruptedException e)
        {
        e.printStackTrace();
        }
    }

    public void goToBasket()
    {
        try {
            WebDriverWait wait=new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(gotobasketButton));
            WebElement gotobasketbutton = driver.findElement(gotobasketButton);
            gotobasketbutton.click();
            Thread.sleep(1000);
            basketPrice = driver.findElement(bybasketProductPrice).getText();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
