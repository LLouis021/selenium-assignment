package tests;

import org.junit.jupiter.api.*;
import pages.AccountsOverviewPage;
import pages.LoginPage;
import utils.ConfigReader;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DependencyTest extends BaseTest {

    private static boolean loginSuccessful = false;

    @Test
    @Order(1)
    public void step1_loginTest() {
        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        AccountsOverviewPage overviewPage = loginPage.loginAs(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        Assertions.assertTrue(overviewPage.isLoginSuccessful(), "Login failed!");

        loginSuccessful = true;
    }

    @Test
    @Order(2)
    public void step2_dependentLogoutTest() {

        Assumptions.assumeTrue(loginSuccessful, "Skipping logout test because step 1 login failed.");


        driver.get(baseUrl);
        AccountsOverviewPage overviewPage = new LoginPage(driver).loginAs(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
        LoginPage returnedLoginPage = overviewPage.logout();

        Assertions.assertEquals("ParaBank | Welcome | Online Banking", driver.getTitle());
    }
}