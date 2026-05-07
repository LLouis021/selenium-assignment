package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomerCarePage extends BasePage {

    private By nameInput = By.xpath("//form[@id='contactForm']//input[@id='name']");
    private By emailInput = By.xpath("//form[@id='contactForm']//input[@id='email']");
    private By phoneInput = By.xpath("//form[@id='contactForm']//input[@id='phone']");
    private By messageTextarea = By.xpath("//form[@id='contactForm']//textarea[@id='message']");
    private By sendButton = By.xpath("//form[@id='contactForm']//input[@type='submit' and @value='Send to Customer Care']");
    private By successMessage = By.xpath("//div[@id='rightPanel']//p[contains(text(),'A Customer Care Representative will be contacting you')]");

    public CustomerCarePage(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(String name, String email, String phone, String message) {
        typeText(nameInput, name);
        typeText(emailInput, email);
        typeText(phoneInput, phone);
        typeText(messageTextarea, message);
        clickElement(sendButton);
    }

    public boolean isMessageSent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}