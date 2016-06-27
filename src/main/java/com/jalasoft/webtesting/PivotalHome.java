package com.jalasoft.webtesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PivotalHome extends PagesPivotal {

    private static final String PIVOTAL_TRACKER_URL = "https://www.pivotaltracker.com/";

    @FindBy(css = "a[href='/signin']")
    private WebElement signInLink;

    public PivotalHome() {
        driver.get(PIVOTAL_TRACKER_URL);
    }

    public Login clickSignInLink() {
        signInLink.click();
        return new Login();
    }

}
