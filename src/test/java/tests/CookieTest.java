package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class CookieTest extends BaseTest {

    @Test
    public void testCookieManipulation() {
        driver.get(baseUrl);


        Cookie testCookie = new Cookie("grade", "max_5");
        driver.manage().addCookie(testCookie);

        Cookie retrievedCookie = driver.manage().getCookieNamed("grade");
        Assertions.assertNotNull(retrievedCookie, "Cookie was not added!");
        Assertions.assertEquals("max_5", retrievedCookie.getValue());


        driver.manage().deleteCookieNamed("grade");
        Assertions.assertNull(driver.manage().getCookieNamed("grade"), "Cookie was not deleted!");
    }
}