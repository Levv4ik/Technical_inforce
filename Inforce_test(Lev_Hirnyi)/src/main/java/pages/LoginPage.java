package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends  BasePage{

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[text()='Epic sadface: Username and password do not match any user in this service']")
    private WebElement loginError;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public LoginPage setUserName(String value){
        usernameField.sendKeys(value);
        return this;
    }

    public LoginPage setPassword(String value){
        passwordField.sendKeys(value);
        return this;
    }

    public AllItemsPage clickLoginButton(){
        loginButton.click();
        return new AllItemsPage();
    }
    public LoginPage clickLoginButtonError(){
        loginButton.click();
        return this;
    }

    public boolean UserNameFieldIsDisplayed(){
        return usernameField.isDisplayed();
    }

    public boolean passwordFieldIsDisplayed(){
        return passwordField.isDisplayed();
    }

    public boolean errorCheck(){
        return loginError.isEnabled();
    }


}
