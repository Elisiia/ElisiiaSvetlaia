package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestMenuItems {

    private WebDriver driver;
    Login objLogin;
    MenuItems objMenuItems;
    Properties properties = loadProperties();

    @DataProvider(name="menuItems")
    public Object[][] dpMethod() {
        return new Object[][] {{objMenuItems.homeItem, "HOME"}, {objMenuItems.contactItem, "CONTACT FORM"},
                {objMenuItems.serviceItem, "SERVICE"}, {objMenuItems.getMetalsItem, "METALS & COLORS"}};
    }
    
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @BeforeClass
    public void test_Home_Page_Appear_Correct() {
        objLogin = new Login(driver);
        objMenuItems = new MenuItems(driver);
        objLogin.openLoginForm();
        objLogin.loginTo(properties.getProperty("page.user"), properties.getProperty("page.password"));
//        objLogin.loginTo("Roman", "Jdi1234");
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
        Assert.assertEquals(objLogin.username.getText(), properties.getProperty("page.expectedUsername"));
        isLogged.assertAll();
    }

    @Test(dataProvider = "menuItems")
    public void isMenuDisplayed(WebElement webElem, String menuTextItem) {
        SoftAssert isExistMenu = new SoftAssert();
        isExistMenu.assertEquals(webElem.getText(), menuTextItem);
        isExistMenu.assertAll();
    }
}
