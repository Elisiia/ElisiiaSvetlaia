package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestFourTextImages {
    private WebDriver driver;
    FourTextImages objFourTextImages;
    Properties properties = loadProperties();

    @DataProvider(name="urlAndTexts")
    public Object[][] dpMethod(){
            return new Object[][] {
                    {objFourTextImages.firstText,"To include good practices\nand ideas from successful\nEPAM project"},
                    {objFourTextImages.secondText, "To be flexible and\ncustomizable"},
                    {objFourTextImages.thirdText, "To be multiplatform"},
                    {objFourTextImages.fourthText, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
            };
    }

    @BeforeClass
    public static void setupClass() { WebDriverManager.chromedriver().setup();}

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        objFourTextImages = new FourTextImages(driver);
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
    @Test(dataProvider = "urlAndTexts")
    public void isTextCorrect(WebElement webElem, String menuTextItem) {
        SoftAssert isTextCorrect = new SoftAssert();
        isTextCorrect.assertEquals(webElem.getText(), menuTextItem);
        System.out.print(webElem.getText() + ",");
        System.out.println(menuTextItem);
        isTextCorrect.assertAll();
    }
}
