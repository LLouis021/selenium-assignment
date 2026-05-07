package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameInput = By.xpath("//div[@id='loginPanel']//input[@name='username']");
    private By passwordInput = By.xpath("//div[@id='loginPanel']//input[@name='password']");
    private By loginButton = By.xpath("//div[@id='loginPanel']//input[@type='submit' and @value='Log In']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public AccountsOverviewPage loginAs(String username, String password) {
        typeText(usernameInput, username);
        typeText(passwordInput, password);
        clickElement(loginButton);
        return new AccountsOverviewPage(driver);
    }
}