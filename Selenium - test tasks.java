import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestSelenium {

    WebDriverManager wdm = new ChromeDriverManager();
    public static WebDriver driver;
    public static WebDriverWait wdwait;


    @BeforeTest
    public void beforeTest(){
        wdm.setup();
    }


    @BeforeMethod
    public void beforeMethod(){

        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }


    public void login(String x, String y){

        WebElement usernameBox = driver.findElement(By.id("user-name"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameBox.sendKeys(x);
        passwordBox.sendKeys(y);
        loginButton.click();
    }

    public static String[] getUsernames(){

        String s = driver.findElement(By.cssSelector("div[class=\"login_credentials\"")).getText();
        System.out.println(s);
        String[] usernames = s.split("\n");
        return usernames;
    }

    public static String getCorrectPassword(){
        return "secret_sauce";
    }

    public static void clickCart(){
        driver.findElement(By.className("shopping_cart_link")).click();
    }

        /*  Sve testove pokretati sa komandom <imeDrajvera>.navigate().to("https://www.saucedemo.com/");
            1. Napisati test koji proverava da li standard user moze da se uloguje kako treba. Assertovati:
            - da je dobijen url: https://www.saucedemo.com/inventory.html
            - da dobijen url nije: https://www.saucedemo.com/ */


        @Test
        public void loginStandardUser() {

            login(getUsernames()[1],getCorrectPassword());
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
            Assert.assertFalse(driver.getCurrentUrl().equals("https://www.saucedemo.com/"));
        }


        /* 2. Napisati test koji provera da li locked out user ne moze da se uloguje. Assertovati:
              - da je dobijen url: https://www.saucedemo.com/
              - da postoji tekst: "Epic sadface: Sorry, this user has been locked out." */


        @Test
        public void loginLockedOutUser(){

            login(getUsernames()[2],getCorrectPassword());
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
            String s = driver.findElement(By.cssSelector("div[class=\"error-message-container error\"")).getText();
            Assert.assertEquals(s,"Epic sadface: Sorry, this user has been locked out.");
        }


        /*
         3. Napisati test koji radi log in i dodaje drugi proizvod po redu u korpu. Assertovati:
            - Korpa nije prazna */



        @Test
        public void addToCartSecondItem(){

            login(getUsernames()[1],getCorrectPassword());
            List<WebElement> listaArtikala = driver.findElements(By.cssSelector("div[class=\"inventory_item_name\""));
            listaArtikala.get(1).click();
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory-item.html?id=0");
            driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
            clickCart();
            Assert.assertTrue(driver.findElement(By.cssSelector("button[class=\"btn btn_secondary btn_small cart_button\"]")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.cssSelector("div[class=\"inventory_item_name\"]")).isDisplayed());
        }


        /*
            4. Napisati test koji radi log in i dodaje Sauce Labs Fleece Jacket u korpu. Assertovati:
               - Korpa nije prazna */


        @Test
        public void addToCartSauceLabsFleeceJacket() throws InterruptedException {

            login(getUsernames()[1],getCorrectPassword());
            WebElement sauceLabsFleeceJacket = driver.findElement(By.id("item_5_title_link"));
            Assert.assertTrue(sauceLabsFleeceJacket.getText().equals("Sauce Labs Fleece Jacket"));
            sauceLabsFleeceJacket.click();
            Thread.sleep(2000);
            driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
            clickCart();
            String s = driver.findElement(By.className("inventory_item_name")).getText();
            Assert.assertEquals(s,"Sauce Labs Fleece Jacket");
            List<WebElement> artikliUKorpi = driver.findElements(By.className("inventory_item_name"));
            Assert.assertFalse(artikliUKorpi.size()==0);
        }


        /*
         5. Napisati test koji radi log in i dodaje proizvoljan artikal u korpu, a zatim proverava da li klikom
            na dugme "Remove" u korpi sa jednim artiklom, dugme uspesno brise taj proizvod iz korpe. Assertovati:
            - Korpa je prazna */


        @Test
        public void removeFromCart() throws InterruptedException {

            login(getUsernames()[1],getCorrectPassword());
            WebElement sauceLabsFleeceJacket = driver.findElement(By.id("item_5_title_link"));
            sauceLabsFleeceJacket.click();
            Thread.sleep(2000);
            driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
            clickCart();
            wdwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[class=\"btn btn_secondary btn_small cart_button\"]")));
            driver.findElement(By.cssSelector("button[class=\"btn btn_secondary btn_small cart_button\"]")).click();
            List<WebElement> listOfRemoveButtons = driver.findElements(By.cssSelector("button[class=\"btn btn_secondary btn_small cart_button\"]"));
            Assert.assertTrue(listOfRemoveButtons.size()==0);
        }


        /* 6. Napisati test koji radi login i zatim provera da li dugme "logout" radi kako treba.
              To dugme se nalazi u gornjem-levom burger meniju.
              Napomena: Ovde ce vam trebati najverovatnije Thread.sleep(). Assertovati:
              - Dobijen url je: "https://www.saucedemo.com/"
              - Dobijen url nije: https://www.saucedemo.com/inventory.html
              - Postoji login dugme */


        @Test
        public void logout() throws InterruptedException {

            login(getUsernames()[1],getCorrectPassword());
            driver.findElement(By.id("react-burger-menu-btn")).click();
            Assert.assertEquals(driver.findElement(By.cssSelector("div[class=\"bm-menu-wrap\"")).getAttribute("aria-hidden"),"false");
            Thread.sleep(2000);
            WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
            logoutButton.click();
            Thread.sleep(2000);
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
            Assert.assertFalse(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
            Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
        }


        /*
           7. Napisati test koji radi log in i proverava da li filter "Name (Z TO A)" radi kako treba.*/

        @Test
        public void nameZToA(){

            login(getUsernames()[1],getCorrectPassword());
            Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
            dropdown.selectByVisibleText("Name (Z to A)");
            List<WebElement> nazivi = driver.findElements(By.className("inventory_item_name"));
            for (int i = 0; i < nazivi.size()-1 ; i++) {
                if(nazivi.get(i).getText().compareTo(nazivi.get(i+1).getText())<0){
                    Assert.fail();
                }
            }
        }

        @AfterMethod
    public void afterMethod(){

            driver.quit();
        }

    }

























