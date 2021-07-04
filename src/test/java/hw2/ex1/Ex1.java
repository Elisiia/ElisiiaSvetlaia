package hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class Ex1 {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testTitle() {
            //WebDriver driver = new ChromeDriver();
            driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
            assertEquals(driver.getTitle(), "Home Page");
//            WebElement loginIcon = driver.findElement (By.id("user-icon"));
//            loginIcon.click();
//            WebElement loginForm = driver.findElement(By.id("name"));
//            loginForm.sendKeys("Roman");
//            WebElement passwordForm = driver.findElement(By.id("password"));
//            passwordForm.sendKeys("Jdi1234");
//            WebElement loginButton = driver.findElement(By.id("login-button"));
//            loginButton.click();
            //SoftAssert sa= new SoftAssert();

            //driver.close();
    }

    @Test
    public void test() {
        WebElement loginIcon = driver.findElement (By.id("user-icon"));
        loginIcon.click();
        WebElement loginForm = driver.findElement(By.id("name"));
        loginForm.sendKeys("Roman");
        WebElement passwordForm = driver.findElement(By.id("password"));
        passwordForm.sendKeys("Jdi1234");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

}
