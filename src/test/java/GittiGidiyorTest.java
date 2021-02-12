import base.Base;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import pages.ProductPage;
import pages.CardPage;

public class GittiGidiyorTest extends Base {

    @BeforeTest
    public void BeforeMethod()
    {
        super.beforemethod();
    }

    @Test
    public void GittiGidiyorAc()
    {
            /* www.gittigidiyor.com sitesi açılır. */
            HomePage homeTest=new HomePage(driver);
            homeTest.gotoHome();

            /* Anasayfanın açıldığı kontrol edilir. */
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.gittigidiyor.com/");
            System.out.println("Anasayfa açıldı.");

            /* Siteye login olunur. */
            LoginPage loginTest= new LoginPage(driver);
            loginTest.SigninButton();
            loginTest.setEmail("aylinalkan95@gmail.com");
            loginTest.setPassword("a123456");
            loginTest.Login();

            /* kullanıcı ismi ile Login işlemi kontrol edilir. */
            Assert.assertEquals(loginTest.loginControl(),"aylinalkan8");
            System.out.println("Login işlemi başarılı.");

            /* Arama kutucuğuna bilgisayar kelimesi girilir. */
            SearchPage searchTest=new SearchPage(driver);
            searchTest.searchInput().sendKeys("bilgisayar");
            searchTest.searchButton().click();

            /* Arama sonuçları sayfasından ikinci sayfa açılır. */
            searchTest.SecondPage();

            /* 2.sayfanın açıldığı kontrol edilir. */
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
            System.out.println("2. Sayfa açıldı.");

            /* Sonuca göre listelenen ürünlerden rastgele bir ürün seçilir. Seçilen ürün sepete eklenir. */
            ProductPage productTest=new ProductPage(driver);
            productTest.chooseProduct();
            productTest.addToBasket();
            productTest.goToBasket();
            /* Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır. */
            Assert.assertEquals(productTest.getProductPrice(),productTest.getBasketPrice());
            System.out.println("Ürün fiyatları aynıdır."+" Product Price: "+productTest.getProductPrice()+" Basket Price: "+productTest.getBasketPrice());

            /* Adet arttırılarak ürün adedinin 2 olduğu doğrulanır. */
            CardPage cardTest=new CardPage(driver);
            cardTest.AddQuantity();
            Assert.assertEquals(cardTest.QuantityControl(),"2");

            /* Ürün sepetten silinerek sepetin boş olduğu kontrol edilir. */
            cardTest.basketProductRemove();
            Assert.assertEquals(cardTest.productRemoveControl(),"Sepetinizde ürün bulunmamaktadır.");

            System.out.println("Test Başarılı.");
    }
    @AfterTest
    public void AfterMethod()
    {
        super.aftermethod();
    }

}
