package com.jalasoft.webtesting.cucumber.stepdefinitions;

import com.jalasoft.webtesting.FormCreateProject;
import com.jalasoft.webtesting.Project;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ProjectSteps {

    private String projectName = "";

    private FormCreateProject formCreateProject;
    private Project project;
    private LoginSteps loginSteps;

    public ProjectSteps(LoginSteps loginSteps) {
        this.loginSteps = loginSteps;
    }


    @When("^I click on the create project button on the Dashboard Page$")
    public void iClickOnTheCreateProjectButtonOnTheDashboardPage() throws Throwable {

        formCreateProject = loginSteps.getDashboard().clickCreateProjectButton();
    }

    @When("^Form to create a project is displayed$")
    public void formToCreateAProjectIsDisplayed() throws Throwable {

    }

    @When("^I type \"([^\"]*)\" in the projects name input field$")
    public void iTypeInTheProjectsNameInputField(String projectName) throws Throwable {
        this.projectName = projectName;
        formCreateProject.setProjectNameTextField(projectName);
    }

    @When("^I click on the list accounts$")
    public void iClickOnTheListAccounts() throws Throwable {
        formCreateProject.clickListBox();
    }

    @When("^I select an account of the list$")
    public void iSelectAnAccountOfTheList() throws Throwable {
        formCreateProject.selectAccountOfListBox();
    }

    @When("^I check on Public Check box option$")
    public void iCheckOnPublicCheckBoxOption() throws Throwable {
        formCreateProject.checkProjectPublicCheckBox();
    }

    @When("^I click on create project button$")
    public void iClickOnCreateProjectButton() throws Throwable {
        project = formCreateProject.clickCreateButton();
    }

    @Then("^It is expected that the display name projects is equal to name create$")
    public void itIsExpectedThatTheDisplayNameProjectsIsEqualToMyNewProject() throws Throwable {
        Assert.assertEquals(projectName, project.getProjectNameText());
    }
}
