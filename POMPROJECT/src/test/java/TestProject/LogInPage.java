package TestProject;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LogInPage extends BasePage {

    public LogInPage(WebDriver browserDriver) {
        super(browserDriver);
    }

    public void logIn(String userName, String password) throws Exception {
        setUserName(userName);
        setPassWord(password);
        clickLogInButton();
    }

    private LogInPage setUserName(String userName) {
        WebElement userNameTextBox = driver.findElement(By.id("user-name"));
        userNameTextBox.sendKeys(userName);
        return this;
    }

    private LogInPage setPassWord(String passWord) {
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys(passWord);
        return this;
    }

    private InventoryPage clickLogInButton() throws Exception {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        verifySuccessfulLogin();
        return new InventoryPage(driver);
    }

    private void verifySuccessfulLogin() throws Exception {
        try {
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        } catch (TimeoutException e) {
            String errorLogin =driver.findElement(By.cssSelector("h3[data-test=error]")).getText();
            throw new Exception("Can not Login : " + errorLogin);
        }
    }
}

