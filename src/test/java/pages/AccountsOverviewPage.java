package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsOverviewPage extends BasePage {

//    private By overviewHeader = By.xpath("//div[@id='rightPanel']//h1[text()='Accounts Overview']");
    private By overviewHeader = By.xpath("//div[@id='rightPanel']//h1[contains(text(),'Accounts Overview')]");
    private By transferFundsLink = By.xpath("//ul[@class='leftmenu']//a[text()='Transfer Funds']");
    private By logoutLink = By.xpath("//div[@id='leftPanel']//a[text()='Log Out']");

    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(overviewHeader)).isDisplayed();
    }

    public TransferFundsPage navigateToTransferFunds() {
        clickElement(transferFundsLink);
        return new TransferFundsPage(driver);
    }

    public LoginPage logout() {
        clickElement(logoutLink);
        return new LoginPage(driver);
    }
}