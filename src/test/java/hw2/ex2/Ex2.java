package hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Ex2 {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        WebElement loginIcon = driver.findElement (By.id("user-icon"));
        loginIcon.click();
        WebElement loginForm = driver.findElement(By.id("name"));
        loginForm.sendKeys("Roman");
        WebElement passwordForm = driver.findElement(By.id("password"));
        passwordForm.sendKeys("Jdi1234");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testTitle() {
        SoftAssert isTitleCorrect = new SoftAssert();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        isTitleCorrect.assertEquals(driver.getTitle(), "Home Page");
        isTitleCorrect.assertAll();
    }

    @Test
    public void isLogged() {
        SoftAssert isLogged = new SoftAssert();
        WebElement username = driver.findElement(By.id("user-name"));
        //assertEquals(username, "ROMAN IOVLEV");
        isLogged.assertEquals(username, "ROMAN IOVLEV");
    }

    @Test
    public void isCheckboxWork() {
        SoftAssert elemWorks = new SoftAssert();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/different-elements.html");
        WebElement waterCheckBox = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[1]/input"));
        waterCheckBox.click();
        WebElement windCheckBox = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[3]/input"));
        windCheckBox.click();
        WebElement selenRadio = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/label[4]/input"));
        selenRadio.click();
        WebElement dropDownColors = driver.findElement(By.cssSelector("select.uui-form-element"));
        WebElement yellowFromDropDown = driver.findElement(By.cssSelector("select.uui-form-element > option:nth-child(4)"));
        dropDownColors.click();
        yellowFromDropDown.click();
    }
}