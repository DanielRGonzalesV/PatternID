package com.jalasoft.webtesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSettings_Project {

    private final String projectName = "Test_Selenium_test11";
    private static Settings_Project settings_project;
    private static Dashboard dashboard;


    @Before
    public void setUp() throws Exception {

//        PivotalHome pivotalHome = new PivotalHome();
//        Login login = pivotalHome.clickSignInLink();
//        login.setUserNameTextField("walter_mercado_jala");
//        login.setPasswordTextField("P@ssw0rd");
//        dashboard = login.clickSignInButton();

        //Design Pattern transporter - navigator
        dashboard = Login.loginAs("walter_mercado_jala", "P@ssw0rd");

        //create Project
        FormCreateProject formCreateProject = dashboard.clickCreateProjectButton();
        formCreateProject.setProjectNameTextField(projectName);
        formCreateProject.clickListBox();
        formCreateProject.selectAccountOfListBox();
        formCreateProject.checkProjectPublicCheckBox();
        Project project = formCreateProject.clickCreateButton();
        settings_project = project.clickSettingsProjectTab();

    }

    @Test
    public void testDeleteProject() {

        String messageProjectDeleted = projectName + " was successfully deleted.";

        //Delete
        settings_project.clickDeleteProjectLink();
        dashboard = settings_project.clickConfirmDeleteProjectButton();
        Assert.assertEquals(messageProjectDeleted, dashboard.getMessageDeleteProject());

    }

    @Test
    public void testEditProject() {

        String projectNewName = "Test_Selenium_change10";
        String projectDescription = "Description change";
        String messageChangesSaved = "Changes saved.";

        //Edit
        settings_project.editNameProject(projectNewName);
        settings_project.editDescriptionProject(projectDescription);
        settings_project.clickSaveSettingProjectButton();
        Assert.assertEquals(messageChangesSaved, settings_project.messageSavedChangesSettings());

    }

//    @After
//     public void TearDown() {
//
//        settings_project.clickDeleteProjectLink();
//        settings_project.clickConfirmDeleteProjectButton();
//    }

}
