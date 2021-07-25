package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImagesVsTexts {
    WebDriver driver;
    @FindBy (xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div1/div/div/span")
    WebElement firstImg;
    @FindBy (xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div2/div/div/span")
    WebElement secondImg;
    @FindBy (xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div3/div/div/span")
    WebElement thirdImg;
    @FindBy (xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div4/div/div/span")
    WebElement fourthImg;

    public ImagesVsTexts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
