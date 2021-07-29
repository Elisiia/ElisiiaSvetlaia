package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestImagesVsTexts {
    WebDriver driver;
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Test
    public void fourPictures() {
        SoftAssert isExistMenu = new SoftAssert();
        for (int i = 1; i <= 4; i++) {
            String xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div[" + i + "]/div/div/span";
            WebElement picture = driver.findElement(By.xpath(xpath));
            isExistMenu.assertTrue(picture.isDisplayed());
        }
        isExistMenu.assertAll();
    }

    @Test
    public void fourTexts() {
        SoftAssert isExistMenu = new SoftAssert();
        for (int i = 1; i <= 4; i++) {
            String xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div[" + i + "]/div/span";
            WebElement text = driver.findElement(By.xpath(xpath));
            isExistMenu.assertFalse(text.getText().isEmpty());
        }
        isExistMenu.assertAll(); }
}
