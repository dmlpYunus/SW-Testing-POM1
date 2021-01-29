package TestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InventoryPage {
    WebDriver driver;
    List <WebElement> initialState;
    List<WebElement> finalState;

    public InventoryPage(WebDriver browserDriver) {
        driver = browserDriver;
        initialState = driver.findElements(By.className("inventory_item"));

    }

    public List<WebElement> getProductNameLinks(){
        List<WebElement> productLinks = driver.findElements(By.className("inventory_item"));
        return productLinks;
    }

    public List<WebElement> getProducts(){
        List<WebElement> products =  driver.findElements(By.className("inventory_item_name"));
        return products;
    }

    public List<WebElement> getProductImages(){
        List<WebElement> productImage =  driver.findElements(By.className("inventory_item_img"));
        return productImage;
    }


    public InventoryPage listItemsAtoZ(){
        WebElement sortContainer= driver.findElement(By.className("product_sort_container"));
        sortContainer.click();
        List<WebElement> options=sortContainer.findElements(By.tagName("option"));
        options.get(0).click();
        finalState = getProductNameLinks();
        return this;
    }

    public InventoryPage listItemsZtoA(){
        WebElement sortContainer= driver.findElement(By.className("product_sort_container"));
        sortContainer.click();
        List<WebElement> options=sortContainer.findElements(By.tagName("option"));
        options.get(1).click();
        finalState = getProductNameLinks();
        return this;
    }

    public InventoryPage listItemsLotoHİ(){
        WebElement sortContainer= driver.findElement(By.className("product_sort_container"));
        sortContainer.click();
        List<WebElement> options=sortContainer.findElements(By.tagName("option"));
        options.get(2).click();
        finalState = getProductNameLinks();
        return this;
    }

    public InventoryPage listItemsLHitoLo(){
        WebElement sortContainer= driver.findElement(By.className("product_sort_container"));
        sortContainer.click();
        List<WebElement> options=sortContainer.findElements(By.tagName("option"));
        options.get(3).click();
        finalState = getProductNameLinks();
        return this;
    }

    public boolean isListed(){
        /*int i =0;
        while(i<initialState.size()){
            System.out.println(i);
            System.out.print(initialState.get(i).getText());
            System.out.println();
            i++;
        }
        System.out.println("----------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----------------------------------------------------------");
        i =0;
        while(i<finalState.size()){
            System.out.println(finalState.get(i).getText());
            i++;
        }*/


        if(!initialState.equals(finalState)) return true;
        return false;
    }

}
