package com.jalasoft.webtesting.cucumber.stepdefinitions;

import com.jalasoft.webtesting.Dashboard;
import com.jalasoft.webtesting.Login;
import com.jalasoft.webtesting.PivotalHome;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    private PivotalHome pivotalHome;
    private Login login;
    private Dashboard dashboard;

    public Dashboard getDashboard() {
        return dashboard;
    }

    @Given("^I want login to Pivotal page$")
    public void iWantLoginToPivotalPage() {
        pivotalHome = new PivotalHome();
    }

    @And("^It show the login form$")
    public void itShowTheLoginForm() {
    }

    //CLick singin button
    @When("^I click on the SigIn button$")
    public void iClickTheSigInButton() {
        login = pivotalHome.clickSignInLink();
    }

    //type in our username
    @When("^I type (.*) in the username input field$")
    public void enterUsername(String user) {
        login.setUserNameTextField(user);
    }

    @And("^I click the next button$")
    public void iClickTheNextButton() {
        login.clickNextButton();
    }

    //type in our password
    @When("^I type (.*) in the password input field$")
    public void enterPassword(String password) {
        login.setPasswordTextField(password);
    }

    //click the login button
    @When("^I click the login button$")
    public void clickLogin() {
        dashboard = login.clickSignInButton();
    }

    @Then("^It is expected that the display name equals (.*)$")
    public void itIsExpectedThatTheDisplayNameEquals(String usernameDisplay) throws Throwable {
        Assert.assertEquals(usernameDisplay, dashboard.getUserNameText());
    }



}