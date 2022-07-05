import jdk.jfr.Description;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.LoginPage;

import java.rmi.dgc.Lease;

public class SwagLabsTest extends BaseTest {

    @DataProvider
    private Object[][] invalidCredsDataProvider() {
        return new Object[][]{
                {valueProvider.getInvalidLoginFromProperties(), valueProvider.getInvalidPasswordFromProperties()},
                {valueProvider.getInvalidLoginFromProperties(), valueProvider.getPasswordFromProperties()},
                {valueProvider.getLoginFromProperties(), valueProvider.getInvalidPasswordFromProperties()},
        };
    }
    
    @Test
    public void loginTEst() {
        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(new LoginPage().UserNameFieldIsDisplayed());
        assertion.assertTrue(new LoginPage().UserNameFieldIsDisplayed());
        assertion.assertAll();
    }

    @Test(dataProvider = "invalidCredsDataProvider")
    public void loginError(String login, String password) {
        boolean errorIsDisplayed = new LoginPage()
                .setUserName(login)
                .setPassword(password)
                .clickLoginButtonError()
                .errorCheck();
        Assert.assertTrue(errorIsDisplayed);
    }


    @Test
    public void urlTest() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        new LoginPage()
                .setUserName(valueProvider.getLoginFromProperties())
                .setPassword(valueProvider.getPasswordFromProperties())
                .clickLoginButton();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void logoutButtonCheck() {
        boolean isButtonVisible = new LoginPage()
                .setUserName(valueProvider.getLoginFromProperties())
                .setPassword(valueProvider.getPasswordFromProperties())
                .clickLoginButton()
                .clickOnHamburgerButton()
                .isLogoutButtonVisible();
        Assert.assertTrue(isButtonVisible);
    }

    @Test
    public void logoutCheck() {
        String expectedUrl = valueProvider.getUrlFromProperties();
        new LoginPage()
                .setUserName(valueProvider.getLoginFromProperties())
                .setPassword(valueProvider.getPasswordFromProperties())
                .clickLoginButton()
                .clickOnHamburgerButton()
                .clickOnLogoutButton();
       String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }
}
