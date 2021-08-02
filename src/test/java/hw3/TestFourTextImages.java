package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestFourTextImages {
    private WebDriver driver;
    FourTextImages objFourTextImages;


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
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
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
