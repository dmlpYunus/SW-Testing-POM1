package TestProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class InventoryItemPage {
        WebDriver driver;
        public InventoryItemPage(WebDriver browserDriver) {
            driver = browserDriver;
        }
        public void addToCart (){
            WebElement addCartButton =  driver.findElement(By.xpath("//*[contains(@class,'btn_primary btn_inventory')]"));
            addCartButton.click();
        }
        public InventoryPage back(){
            WebElement backButton=driver.findElement(By.className("inventory_details_back_button"));
            backButton.click();
            return new InventoryPage(driver);
        }
    public CartPage toShoppingCartPage() throws Exception {
        WebElement shoppingCartButton = driver.findElement(By.xpath("//*[contains(@class,'svg-inline--fa fa-shopping-cart fa-w-18 fa-3x')]"));
        shoppingCartButton.click();
        return new CartPage(driver);
    }

    }
