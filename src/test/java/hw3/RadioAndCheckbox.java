package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioAndCheckbox {
    WebDriver driver;
    @FindBy(xpath="/html/body/div/div[2]/main/div[2]/div/div[2]/label[1]/input")
    WebElement waterCheckBox;
    @FindBy(xpath="/html/body/div/div[2]/main/div[2]/div/div[2]/label[3]/input")
    WebElement windCheckBox;
    @FindBy(xpath="/html/body/div/div[2]/main/div[2]/div/div[3]/label[4]/input")
    WebElement selenRadio;
    @FindBy (css="select.uui-form-element")
    WebElement dropDownColors;
    @FindBy (css="select.uui-form-element > option:nth-child(4)\"")
    WebElement yellowFromDropDown;

    public RadioAndCheckbox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
