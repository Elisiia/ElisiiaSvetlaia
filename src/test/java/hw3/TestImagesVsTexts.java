package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestImagesVsTexts {
    WebDriver driver;
    Properties properties = loadProperties();
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.navigate().to(properties.getProperty("page.homeUrl"));
    }

    private Properties loadProperties() {
        try (InputStream input = TestMenuItems.class.getClassLoader().getResourceAsStream("resources.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
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
