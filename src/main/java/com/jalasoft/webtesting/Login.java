package com.jalasoft.webtesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by danielgonzales on 6/15/2016.
 */
public class Login extends PagesPivotal {

    @FindBy(id = "credentials_username")
    private WebElement userNameTextField;

    @FindBy(id = "credentials_password")
    private WebElement passwordTextField;

    @FindBy(className = "app_signup_submit_button_button")
    private WebElement sigInButton;

    public void setUserNameTextField(String userName) {
        userNameTextField.clear();
        userNameTextField.sendKeys(userName);
    }

    public void setPasswordTextField(String password) {
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
    }

    public Dashboard clickSignInButton() {
        sigInButton.click();
        return new Dashboard();
    }

    public static Dashboard loginAs(String username, String password) {
        PivotalHome pivotalHome = new PivotalHome();
        Dashboard dashboard = new Dashboard();
        if (!dashboard.getUserNameText().equalsIgnoreCase(username)) {
            Login login = pivotalHome.clickSignInLink();
            login.setUserNameTextField(username);
            login.setPasswordTextField(password);
            return login.clickSignInButton();
        }
        return dashboard;
    }


}
