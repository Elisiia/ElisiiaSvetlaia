package hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class Ex1 {

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
    public void isMenuDisplayed() {
        SoftAssert isExistMenu = new SoftAssert();
         //assert HOME
        WebElement homeItem = driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[1]/a"));
        isExistMenu.assertEquals(homeItem.getText(), "HOME");
        //assert contact form
        WebElement contactItem = driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[2]/a"));
        isExistMenu.assertEquals(contactItem.getText(), "CONTACT FORM");
        //assert service
        WebElement serviceItem = driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[3]/a"));
        isExistMenu.assertEquals(serviceItem.getText(), "SERVICE");
        //assert metals & colors
        WebElement metalsItem = driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[4]/a"));
        isExistMenu.assertEquals(metalsItem.getText(), "METALS & COLORS");
        //collect soft asserts
        isExistMenu.assertAll();
    }

    @Test
    public void fourPictures() {
        SoftAssert isPictureExist = new SoftAssert();
        for (int i = 1; i <= 4; i++) {
            String xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div[" + i + "]/div/div/span";
            WebElement picture = driver.findElement(By.xpath(xpath));
            isPictureExist.assertTrue(picture.isDisplayed());
        }
        isPictureExist.assertAll();
    }

    @Test
    public void textUnderPictures (){
        SoftAssert textUnderPictureExist = new SoftAssert();
        WebElement firstText = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[1]/div/span"));
        textUnderPictureExist.assertEquals(firstText.getText(), "To include good practices\nand ideas from successful\nEPAM project");
        WebElement secondText = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[2]/div/span"));
        textUnderPictureExist.assertEquals(secondText.getText(), "To be flexible and\ncustomizable");
        WebElement thirdText = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[3]/div/span"));
        textUnderPictureExist.assertEquals(thirdText.getText(), "To be multiplatform");
        WebElement fourthText = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[4]/div/span"));
        textUnderPictureExist.assertEquals(fourthText.getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        textUnderPictureExist.assertAll();
    }

    @Test
    public void fourTexts() {
        SoftAssert isExistMenu = new SoftAssert();
        for (int i = 1; i <= 4; i++) {
            String xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div[" + i + "]/div/span";
            WebElement text = driver.findElement(By.xpath(xpath));
            isExistMenu.assertFalse(text.getText().isEmpty());
        }
        isExistMenu.assertAll();
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

    @Test
    public void switchToFrame() {
        for (WebElement elem :driver.findElements(By.tagName("iframe"))) {
            driver.switchTo().frame(elem);
            System.out.println("nyan");
            driver.switchTo().parentFrame();
        }
    }

    @Test
    public void verticalMenu() {
        SoftAssert isMenuItemNamedCorrectly = new SoftAssert();
        // “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("Home");
        menuItems.add("Contact form");
        menuItems.add("Service");
        menuItems.add("Metals & Colors");
        menuItems.add("Elements packs");

        for (int i = 1; i <= 5; i++) {
            String xpath = "/html/body/div/div[1]/div/div[1]/div/div[1]/ul/li[" + i + "]/a/span";
            WebElement item = driver.findElement(By.xpath(xpath));
            isMenuItemNamedCorrectly.assertEquals(item.getText(), menuItems.get(i-1));
        }
        isMenuItemNamedCorrectly.assertAll();
    }
}
