package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private static String email;
    private static String password;

    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    By signinModal=By.xpath("//div[@class='gekhq4-5 hUmHQV']");
    By signinbutton=By.xpath("//a[.='Giriş Yap']");


    public WebElement SigninModal()
    {
        return driver.findElement (signinModal);
    }

    public void SigninButton()
    {
        try {
            Actions actions = new Actions(driver);
            WebElement OpensigninModal = driver.findElement(signinModal);
            actions.moveToElement(OpensigninModal).perform();

            WebDriverWait wait=new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(signinbutton));
            WebElement signinButton = driver.findElement(signinbutton);
            signinButton.click();
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    By Email=By.xpath("//input[@id='L-UserNameField']");
    By Password=By.xpath("//input[@id='L-PasswordField']");
    By loginButton=By.xpath("//input[@id='gg-login-enter']");


    public void setEmail(String email)
    {
        this.email=email;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public void Login()
    {
        try
        {
            driver.findElement(Email).sendKeys(email);
            driver.findElement(Password).sendKeys(password);
            Thread.sleep(5000);
            WebElement LoginButton = driver.findElement(loginButton);
            LoginButton.click();
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public String loginControl(){
        String logcontrol = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div/div[2]/span")).getText();
        return logcontrol;
    }

}
