package com.jalasoft.webtesting.junit;

import com.jalasoft.webtesting.Dashboard;
import com.jalasoft.webtesting.FormCreateProject;
import com.jalasoft.webtesting.Login;
import com.jalasoft.webtesting.PivotalHome;
import com.jalasoft.webtesting.Project;
import org.junit.Assert;
import org.junit.Test;

public class TestFormCreateProject {

        @Test
    public void testCreateProject() {

        String projectName = "Test_Selenium118";

        PivotalHome pivotalHome = new PivotalHome();
        Login login = pivotalHome.clickSignInLink();
        login.setUserNameTextField("walter_mercado_jala");
        login.setPasswordTextField("P@ssw0rd");
        Dashboard dashboard = login.clickSignInButton();
        FormCreateProject formCreateProject = dashboard.clickCreateProjectButton();
        formCreateProject.setProjectNameTextField(projectName);
        formCreateProject.clickListBox();
        formCreateProject.selectAccountOfListBox();
        formCreateProject.checkProjectPublicCheckBox();
        Project project = formCreateProject.clickCreateButton();
        Assert.assertEquals(projectName, project.getProjectNameText());
    }
}
