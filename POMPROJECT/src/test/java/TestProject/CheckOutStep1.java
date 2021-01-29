package TestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class CheckOutStep1 {
    WebDriver driver;

    public CheckOutStep1(WebDriver driver){

        this.driver=driver;
    }

    public CheckOutStep1 checkOut(String name, String surname, String email){
        WebElement firstNameTextField = driver.findElement(By.id("first-name"));
        WebElement lastNameTextField = driver.findElement(By.id("last-name"));
        WebElement postalCodeTextField = driver.findElement(By.id("postal-code"));
        firstNameTextField.sendKeys(name);
        lastNameTextField.sendKeys(surname);
        postalCodeTextField.sendKeys(email);
        return this;
    }


    public  CheckOutStep2 continueing(){
        WebElement continueButton = driver.findElement(By.xpath("//*[contains(@class,'btn_primary cart_button')]"));
        continueButton.click();
        return new CheckOutStep2(driver);
    }

    public CartPage Cancel(){
        WebElement cancelButton = driver.findElement(By.xpath("//*[contains(@class,'cart_cancel_link btn_secondary')]"));
        cancelButton.click();
        return new CartPage(driver);
    }

    }