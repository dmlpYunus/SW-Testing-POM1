package TestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutStep2 {
    WebDriver driver;

    public CheckOutStep2(WebDriver driver){
        this.driver=driver;

    }
    public void finish(){
        WebElement finishButton=driver.findElement(By.xpath("//*[contains(@class,'btn_action cart_button')]"));
        finishButton.click();
    }

}