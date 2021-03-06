package com.jalasoft.webtesting.junit;

import com.jalasoft.webtesting.Dashboard;
import com.jalasoft.webtesting.Login;
import com.jalasoft.webtesting.PivotalHome;
import com.jalasoft.webtesting.Settings_Project;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by danielgonzales on 6/15/2016.
 */
public class TestDashboard {

    @Test
    public void testEnterSettingsProject() {

        String projectName = "Test_Selenium113";

        PivotalHome pivotalHome = new PivotalHome();
        Login login = pivotalHome.clickSignInLink();
        login.setUserNameTextField("walter_mercado_jala");
        login.setPasswordTextField("P@ssw0rd");
        Dashboard dashboard = login.clickSignInButton();
        Settings_Project settings_project = dashboard.clickSettingsProjectButton();
        Assert.assertEquals(projectName, settings_project.getProjectNameText());

    }




}

