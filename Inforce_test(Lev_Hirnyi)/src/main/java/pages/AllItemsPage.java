package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllItemsPage extends BasePage{

    @FindBy(id = "react-burger-menu-btn")
    private WebElement hamburgerButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    public AllItemsPage(){
        PageFactory.initElements(driver,this);
    }

    public AllItemsPage clickOnHamburgerButton(){
        hamburgerButton.click();
        return this;
    }
    public LoginPage clickOnLogoutButton(){
        logoutButton.click();
        return new LoginPage();
    }

    public boolean isLogoutButtonVisible(){
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        return logoutButton.isDisplayed();
    }
}
