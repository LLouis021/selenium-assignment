package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.AccountsOverviewPage;
import pages.CustomerCarePage;
import pages.LoginPage;
import pages.TransferFundsPage;
import utils.ConfigReader;
import java.util.UUID;

public class ParaBankTest extends BaseTest {

    @Test
    public void testLoginAndLogoutFlow() {
        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);

        AccountsOverviewPage overviewPage = loginPage.loginAs(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
        Assertions.assertTrue(overviewPage.isLoginSuccessful(), "Login failed!");

        LoginPage returnedLoginPage = overviewPage.logout();
        Assertions.assertEquals("ParaBank | Welcome | Online Banking", driver.getTitle());
    }

    @Test
    public void testCustomerCareWithRandomData() {
        driver.get(baseUrl + "contact.htm");

        String randomName = "User_" + UUID.randomUUID().toString().substring(0, 5);
        String randomEmail = randomName + "@test.com";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);");

        CustomerCarePage carePage = new CustomerCarePage(driver);
        carePage.fillContactForm(randomName, randomEmail, "123456789", "This is a test message.");

        Assertions.assertTrue(carePage.isMessageSent(), "Customer care message was not sent!");
    }

    @Test
    public void testBrowserHistoryNavigation() {
        driver.get(baseUrl);
        driver.navigate().to(baseUrl + "about.htm");

        driver.navigate().back();
        Assertions.assertEquals("ParaBank | Welcome | Online Banking", driver.getTitle());

        driver.navigate().forward();
        Assertions.assertEquals("ParaBank | About Us", driver.getTitle());
    }

    @Test
    public void testMultipleStaticPages() {
        String[] pagesToTest = {"about.htm", "services.htm", "sitemap.htm"};

        for (String page : pagesToTest) {
            driver.get(baseUrl + page);
            Assertions.assertTrue(driver.getTitle().contains("ParaBank"), "Title mismatch on " + page);
            Assertions.assertTrue(driver.findElement(By.id("headerPanel")).isDisplayed());
        }
    }
}