package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FourTextImages {

    WebDriver driver;
    @FindBy (xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div[1]/div/span")
    WebElement firstText;
    @FindBy (xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div[2]/div/span")
    WebElement secondText;
    @FindBy (xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div[3]/div/span")
    WebElement thirdText;
    @FindBy (xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div[4]/div/span")
    WebElement fourthText;


    public FourTextImages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
