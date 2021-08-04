package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestRadioAndCheckbox {
    private WebDriver driver;
    Properties properties = loadProperties();
    Login objLogin;
    RadioAndCheckbox objRadioAndCheckbox;

    @BeforeClass
    public static void setupClass() { WebDriverManager.chromedriver().setup();}

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        objRadioAndCheckbox = new RadioAndCheckbox(driver);
        objLogin = new Login(driver);
        driver.navigate().to(properties.getProperty("page.homeUrl"));
        objLogin.loginTo(properties.getProperty("page.user"), properties.getProperty("page.password"));
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
    public void isLogged() {
        SoftAssert isLogged = new SoftAssert();
        //Assert.assertEquals(objLogin.username.getText(), "ROMAN IOVLEV");
        Assert.assertEquals(objLogin.username.getText(), properties.getProperty("page.expectedUsername"));
        isLogged.assertAll();
    }
    @Test
    public void TestRadioAndCheckbox() {
        SoftAssert elemWorks = new SoftAssert();
        driver.navigate().to(properties.getProperty("page.serviceUrl"));
        objRadioAndCheckbox.waterCheckBox.click();
        objRadioAndCheckbox.windCheckBox.click();
        objRadioAndCheckbox.selenRadio.click();
        objRadioAndCheckbox.dropDownColors.click();
        //objRadioAndCheckbox.yellowFromDropDown.click();
        elemWorks.assertAll();
    }
}
