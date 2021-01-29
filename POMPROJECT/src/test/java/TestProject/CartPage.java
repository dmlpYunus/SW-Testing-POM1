package TestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver browserDriver) {
        driver = browserDriver;
    }

    public void checkout(){
        WebElement checkout=driver.findElement(By.xpath("//*[contains(@class,'btn_action checkout_button')]"));
        checkout.click();
    }

    public int getNumberOfItemsCart() {
        List <WebElement> itemsOnCharts = driver.findElements(By.className("inventory_item_name"));
        return itemsOnCharts.size();
    }

}
