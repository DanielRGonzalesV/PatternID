package com.jalasoft.webtesting;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TestFormCreateProjectCucumber {

    private String projectName = "";

    private FormCreateProject formCreateProject;
    private Project project;
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

    @When("^I click on the create project button on the Dashboard Page$")
    public void I_click_on_the_create_project_button_on_the_Dashboard_Page() throws Throwable {
        formCreateProject = dashboard.clickCreateProjectButton();
    }

    @When("^Form to create a project is displayed$")
    public void Form_to_create_a_project_is_displayed() throws Throwable {

    }

    @When("^I type \"([^\"]*)\" in the projects name input field$")
    public void iTypeInTheProjectsNameInputField(String projectName) throws Throwable {
        this.projectName = projectName;
        formCreateProject.setProjectNameTextField(projectName);
    }

    @When("^I click on the list accounts$")
    public void I_click_on_the_list_accounts() throws Throwable {
        formCreateProject.clickListBox();
    }

    @When("^I select an account of the list$")
    public void I_select_an_account_of_the_list() throws Throwable {
        formCreateProject.selectAccountOfListBox();
    }

    @When("^I check on Public Check box option$")
    public void I_check_on_Public_Check_box_option() throws Throwable {
        formCreateProject.checkProjectPublicCheckBox();
    }

    @When("^I click on create project button$")
    public void I_click_on_create_project_button() throws Throwable {
        project = formCreateProject.clickCreateButton();
    }

    @Then("^It is expected that the display name projects is equal to name create$")
    public void It_is_expected_that_the_display_name_projects_is_equal_to_My_new_project() throws Throwable {
        Assert.assertEquals(projectName, project.getProjectNameText());
    }
}
