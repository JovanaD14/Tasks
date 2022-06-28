import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class DomaciSreda {

    public static WebDriverManager wdm = new ChromeDriverManager();
    public static WebDriver driver;
    public static WebDriverWait wdw;


    @BeforeTest
    public void beforeTest() {

        wdm.setup();
    }


    @BeforeMethod
    public void beforeMethod() {

        driver = new ChromeDriver();
        wdw = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }


    public static String getCorrectPassword(){

        return "secret_sauce";
    }

    public static void login(String x, String y){

        WebElement usernameBox = driver.findElement(By.id("user-name"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameBox.sendKeys(x);
        passwordBox.sendKeys(y);
        loginButton.click();
    }

    public void clickCart() throws InterruptedException {

        driver.findElement(By.id("shopping_cart_container")).click();
    }


    @Test
    public void successfulLoginUsername1(){

        login("standard_user", getCorrectPassword() );
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        List<WebElement> lista404 =driver.findElements(By.cssSelector("img[src=\"/static/media/sl-404.168b1cce.jpg\""));
        Assert.assertEquals(lista404.size(), 0);
    }


    @Test
    public void loginUsername2(){

        login("locked_out_user", getCorrectPassword() );
        WebElement errorMessage = driver.findElement(By.cssSelector("div[class=\"error-message-container error\"]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }


    @Test
    public void loginUsername3(){

        login("problem_user", getCorrectPassword() );
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(driver.findElement(By.cssSelector("img[src=\"/static/media/sl-404.168b1cce.jpg\"")).isDisplayed());
    }



    @Test
    public void loginUsername4() {

        login("performance_glitch_user", getCorrectPassword());
        //wdwait.until(ExpectedConditions.urlMatches("https://www.saucedemo.com/inventory.html"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }


    @Test
    public void loginInvalidUsername(){

        login("usernameX",getCorrectPassword());
        WebElement e = driver.findElement(By.cssSelector("h3[data-test=\"error\"]"));
        System.out.println(e.getText());
        Assert.assertEquals(e.getText(),"Epic sadface: Username and password do not match any user in this service");
    }


    @Test
    public void loginInvalidPassword(){

        login("standard_user","98987");
        WebElement e = driver.findElement(By.cssSelector("h3[data-test=\"error\"]"));
        System.out.println(e.getText());
        Assert.assertEquals(e.getText(),"Epic sadface: Username and password do not match any user in this service");
    }


    @Test
    public void addToCart() throws InterruptedException {

        login("standard_user",getCorrectPassword());
        Thread.sleep(1500);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1500);
        Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed());
        clickCart();
        WebElement product1InCart = driver.findElement(By.cssSelector("div[class=\"inventory_item_name\"]"));
        System.out.println(product1InCart.getText());
        Assert.assertEquals(product1InCart.getText(),"Sauce Labs Backpack");
    }


    @Test
    public void removeProductFromCart() throws InterruptedException {

        addToCart();
        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeButton.click();
        Thread.sleep(2000);
        List<WebElement> lista = driver.findElements(By.id("remove-sauce-labs-backpack"));
        Assert.assertEquals(lista.size(),0);
        driver.findElement(By.id("continue-shopping")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }


    @Test
    public void buyProduct () throws InterruptedException {

        addToCart();
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
        driver.findElement(By.id("first-name")).sendKeys("Petar");
        driver.findElement(By.id("last-name")).sendKeys("Petrovic");
        driver.findElement(By.id("postal-code")).sendKeys("11000");
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        WebElement checkProduct = driver.findElement(By.cssSelector("div[class=\"inventory_item_name\""));
        Assert.assertEquals(checkProduct.getText(),"Sauce Labs Backpack");
        WebElement checkQuantity = driver.findElement(By.cssSelector("div[class=\"cart_quantity\"]"));
        Assert.assertEquals(checkQuantity.getText(),"1");
        driver.findElement(By.id("finish")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
        WebElement thankYou = driver.findElement(By.cssSelector("h2[class=\"complete-header\"]"));
        Assert.assertEquals(thankYou.getText(),"THANK YOU FOR YOUR ORDER");
    }

    @AfterMethod
    public static void afterMethod(){

        driver.quit();
    }

}


