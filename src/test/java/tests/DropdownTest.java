package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.ConfigReader;
import java.time.Duration;

public class DropdownTest extends BaseTest {

    @Test
    public void testDropdownSelection() {

        driver.get(baseUrl);
        new LoginPage(driver).loginAs(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));


        driver.findElement(By.xpath("//a[text()='Open New Account']")).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("type")));


        Select accountTypeSelect = new Select(dropdownElement);
        accountTypeSelect.selectByVisibleText("SAVINGS");


        Assertions.assertEquals("SAVINGS", accountTypeSelect.getFirstSelectedOption().getText());
    }
}