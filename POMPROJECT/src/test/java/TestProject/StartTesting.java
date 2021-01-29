package TestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class StartTesting {
    WebDriver driver;
    WebDriverWait wait;
    SoftAssert softAssert = new SoftAssert();


    @Test(dataProviderClass = DataProvidingClass.class,dataProvider = "Yunus_Provider")
    public void StartTest(String user, String passwd) throws Exception {
        //INITIAL
        System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/index.html");
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("login-button")));


        //LOGIN
        LogInPage logInPage = new LogInPage(driver);
        logInPage.logIn(user,passwd);


        //LIST ITEMS ORDER BY PRICE LOW TO HIGH
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.listItemsLotoHİ();
        boolean isListed=inventoryPage.isListed();
        Assert.assertEquals(isListed,true);


        //Select first item link
        List<WebElement> products = inventoryPage.getProducts();
        products.get(0).click();

        //Add item to the shopping cart
        InventoryItemPage inventoryItemPage = new InventoryItemPage(driver);
        inventoryItemPage.addToCart();

        //Back to Inventory page and add the select first item by clicking its image
        List<WebElement> productsAfterAdding=inventoryItemPage.back().getProductImages();
        productsAfterAdding.get(0).click();



        //Add it to the shopping cart
        inventoryItemPage.addToCart();

        //Proceed shopping cart page
        CartPage cart = inventoryItemPage.toShoppingCartPage();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
        System.out.println(cart.getNumberOfItemsCart());


        //Check the items on that list are correct
        Assert.assertEquals(cart.getNumberOfItemsCart(),2);

        //Proceed to checkout
        cart.checkout();
        CheckOutStep1 checkOutOne =new CheckOutStep1(driver);
        checkOutOne.checkOut("Yunus", "Dumlupınar","@gmail");
        CheckOutStep2 checkOutTwo=checkOutOne.continueing();

        //Complete and Logout
        checkOutTwo.finish();
        MenuPage menuPage = new MenuPage(driver);
        menuPage.logOut();

    }
    public static void main(String args[]) throws Exception {
        //  SauceDemoPOMAdvancedTest test = new SauceDemoPOMAdvancedTest();
        // test.SauceDemoAddCartAdvanced();
    }

}