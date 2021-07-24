package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;
    @FindBy(id="user-icon")
    WebElement loginIcon;
    @FindBy(id="name")
    WebElement loginForm;
    @FindBy(id="password")
    WebElement passwordForm;
    @FindBy(id="login-button")
    WebElement loginButton;


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

    public void clickLogin(){
        loginButton.click();    }

    public void toLogin() { //(String login, String Password) {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        loginIcon.click();
        loginForm.sendKeys("Roman");
        passwordForm.sendKeys("Jdi1234");
        loginButton.click();
    }

    public void loginToGuru99(String strUserName,String strPasword){
        this.setLoginName(strUserName);
        this.setPasswordForm(strPasword);
        this.clickLogin();
    }
}
