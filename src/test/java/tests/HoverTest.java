package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverTest extends BaseTest {

    @Test
    public void testHoverAction() {
        driver.get(baseUrl);

        // 定位到左侧导航栏的 Services
        WebElement servicesMenu = driver.findElement(By.xpath("//ul[@class='leftmenu']//a[text()='Services']"));

        // 使用 Actions 类执行悬停动作 (满足 hover_test 要求)
        Actions actions = new Actions(driver);
        actions.moveToElement(servicesMenu).perform();

        // 断言悬停后元素正常显示
        Assertions.assertTrue(servicesMenu.isDisplayed(), "Menu item is not visible after hover");
    }
}