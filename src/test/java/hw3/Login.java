package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    //login
    WebDriver driver;
    @FindBy(id="user-icon")
    WebElement loginIcon;
    @FindBy(id="name")
    WebElement loginForm;
    @FindBy(id="password")
    WebElement passwordForm;
    @FindBy(id="login-button")
    WebElement loginButton;
    @FindBy (id="user-name")
    WebElement username;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLoginForm () {
        loginIcon.click();
    }

    public void setLoginName(String strUserName) {
        loginForm.sendKeys(strUserName);
    }

    public void setPasswordForm(String strPasswd) {
        passwordForm.sendKeys(strPasswd);
    }

    public void clickLogin(){ loginButton.click();    }

    public void loginTo(String strUserName,String strPasword){
        this.openLoginForm();
        this.setLoginName(strUserName);
        this.setPasswordForm(strPasword);
        this.clickLogin();
    }
}
