package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class CookieTest extends BaseTest {

    @Test
    public void testCookieManipulation() {
        driver.get(baseUrl);


        Cookie testCookie = new Cookie("student_grade", "max_score_5");
        driver.manage().addCookie(testCookie);

        Cookie retrievedCookie = driver.manage().getCookieNamed("student_grade");
        Assertions.assertNotNull(retrievedCookie, "Cookie was not added!");
        Assertions.assertEquals("max_score_5", retrievedCookie.getValue());


        driver.manage().deleteCookieNamed("student_grade");
        Assertions.assertNull(driver.manage().getCookieNamed("student_grade"), "Cookie was not deleted!");
    }
}