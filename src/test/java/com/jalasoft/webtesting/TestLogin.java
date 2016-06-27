package com.jalasoft.webtesting;

        import org.junit.Assert;
        import org.junit.Test;

public class TestLogin {

    @Test
    public void testLogin() {

        PivotalHome pivotalHome = new PivotalHome();
        Login login = pivotalHome.clickSignInLink();
        login.setUserNameTextField("walter_mercado_jala");
        login.setPasswordTextField("P@ssw0rd");
        Dashboard dashboard = login.clickSignInButton();
        String expectedUserName = "WALTER_MERCADO_JALA";
        Assert.assertEquals(expectedUserName, dashboard.getUserNameText());
    }

}