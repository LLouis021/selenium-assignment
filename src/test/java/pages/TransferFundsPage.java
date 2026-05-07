package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferFundsPage extends BasePage {

    private By amountInput = By.xpath("//form[@id='transfer']//input[@id='amount']");
    private By transferButton = By.xpath("//form[@id='transfer']//input[@type='submit' and @value='Transfer']");
    private By successMessage = By.xpath("//div[@id='rightPanel']//h1[text()='Transfer Complete!']");

    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }

    public void transferAmount(String amount) throws InterruptedException {
        Thread.sleep(1000);
        typeText(amountInput, amount);
        clickElement(transferButton);
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }
}