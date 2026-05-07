package tests;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotListener implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        // 当测试失败时，自动获取 WebDriver 并截图
        Object testInstance = context.getRequiredTestInstance();
        if (testInstance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testInstance).driver;
            if (driver != null) {
                try {
                    File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    File target = new File("target/screenshots/" + context.getDisplayName() + ".png");
                    target.getParentFile().mkdirs();
                    Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Screenshot saved on failure: " + target.getAbsolutePath());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}