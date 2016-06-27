package com.jalasoft.webtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PagesPivotal {

    protected WebDriver driver;

    public PagesPivotal() {
        driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }
}

