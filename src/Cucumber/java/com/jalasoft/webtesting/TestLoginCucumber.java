package com.jalasoft.webtesting;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TestLoginCucumber {

    private PivotalHome pivotalHome;
    private Login login;
    private Dashboard dashboard;


    @Given("^I want login to Pivotal page$")
    public void iWantLoginToPivotalPage() throws Throwable {
        pivotalHome = new PivotalHome();
    }

    @And("^It show the login form$")
    public void itShowTheLoginForm() throws Throwable {

    }

    //CLick singin button
    @When("^I click on the SigIn button$")
    public void iClickTheSigInButton() throws Throwable {
        login = pivotalHome.clickSignInLink();
    }

    //type in our username
    @When("^I type (.*) in the username input field$")
    public void enterUsername(String user) throws Exception {
        login.setUserNameTextField("walter_mercado_jala");

    }

    //type in our password
    @When("^I type (.*) in the password input field$")
    public void enterPassword(String password) throws Exception {
        login.setPasswordTextField("P@ssw0rd");
    }

    //click the login button
    @When("^I click the login button$")
    public void clickLogin() throws Exception {
        dashboard = login.clickSignInButton();
    }


    @Then("^It is expected that the display name equals (.*)$")
    public void itIsExpectedThatTheDisplayNameEqualsWALTER_MERCADO_JALA(String usernameDisplay) throws Throwable {
        Assert.assertEquals(usernameDisplay, dashboard.getUserNameText());
    }


    @After
    public void cleanUp() {
        //driver.quit();
    }

}