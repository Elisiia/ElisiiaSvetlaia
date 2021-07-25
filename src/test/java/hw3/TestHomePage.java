package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestHomePage {

    private WebDriver driver;
    Login objLogin;
    HomePage objHomePage;


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
        objLogin.openLoginForm();
//        String loginPageTitle = objLogin.getLoginTitle();
//        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        objLogin.loginTo("Roman", "Jdi1234");
//        objHomePage = new HomePage(driver);
//        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }
    @Test
    public void isLogged() {
        SoftAssert isLogged = new SoftAssert();
        WebElement username = driver.findElement(By.id("user-name"));
        //assertEquals(username, "ROMAN IOVLEV");
        isLogged.assertEquals(username, "ROMAN IOVLEV");
    }
}