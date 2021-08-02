package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestFrames {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() { WebDriverManager.chromedriver().setup();}

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Test
    public void isButtonInFrameExist () {
        SoftAssert buttonInFrameExist = new SoftAssert();
        boolean isButtonInFrame = false;
        for (WebElement elem :driver.findElements(By.tagName("iframe"))) {
            driver.switchTo().frame(elem);
            List<WebElement> findAnyButton = driver.findElements(By.tagName("button"));
            driver.switchTo().parentFrame();
            if (findAnyButton.isEmpty()) {
                continue;
            } else {
                isButtonInFrame = true;
            }
        }
        buttonInFrameExist.assertTrue(isButtonInFrame);
        buttonInFrameExist.assertAll();
    }

}

