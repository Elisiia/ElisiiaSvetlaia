package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuItems {

    WebDriver driver;
    @FindBy(id="user-icon")
    WebElement loginIcon;
    @FindBy(id="name")
    WebElement loginForm;
    @FindBy(xpath="/html/body/header/div/nav/ul[1]/li[1]/a")
    WebElement homeItem;
    @FindBy (xpath="/html/body/header/div/nav/ul[1]/li[2]/a")
    WebElement contactItem;
    @FindBy (xpath="/html/body/header/div/nav/ul[1]/li[3]/a")
    WebElement serviceItem;
    @FindBy (xpath="/html/body/header/div/nav/ul[1]/li[4]/a")
    WebElement getMetalsItem;

    public MenuItems(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
