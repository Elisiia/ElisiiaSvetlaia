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

public class TestMenuItems {

    private WebDriver driver;
    Login objLogin;
    MenuItems objMenuItems;

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
        objLogin.loginTo("Roman", "Jdi1234");

    }
    @Test
    public void isLogged() {
        SoftAssert isLogged = new SoftAssert();
        Assert.assertEquals(objLogin.username.getText(), "ROMAN IOVLEV");
        isLogged.assertAll();
    }

    @Test(dataProvider = "menuItems")
    public void isMenuDisplayed(WebElement webElem, String menuTextItem) {
        SoftAssert isExistMenu = new SoftAssert();
        isExistMenu.assertEquals(webElem.getText(), menuTextItem);
        isExistMenu.assertAll();
    }
}
