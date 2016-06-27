package com.jalasoft.webtesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Settings_Project extends PagesPivotal {

    @FindBy(className = "tc_header_project_name")
    private WebElement projectNameText;

    @FindBy(id = "delete_link")
    private WebElement deleteProjectLink;

    @FindBy(id = "confirm_delete")
    private WebElement confirmDeleteProjectButton;

    @FindBy(id = "project_name")
    private WebElement projectNameTextField;

    @FindBy(id = "project_description")
    private WebElement projectDescriptionTextField;

    @FindBy(className = "save_bar__submit")
    private  WebElement saveSettingProjectButton;

    @FindBy(className = "message")
    private WebElement messageSavedChangesSettings;


    public String getProjectNameText() {
        return projectNameText.getText();
    }

    public void clickDeleteProjectLink() {
        deleteProjectLink.click();
    }

    public Dashboard clickConfirmDeleteProjectButton() {
        confirmDeleteProjectButton.click();
        return new Dashboard();
    }

    //Edit Name and description project

    public void editNameProject(String newNameProject){
        projectNameTextField.clear();
        projectNameTextField.sendKeys(newNameProject);
    }

    public void editDescriptionProject(String newDescriptionProject){
        projectDescriptionTextField.clear();
        projectDescriptionTextField.sendKeys(newDescriptionProject);
    }

    public void clickSaveSettingProjectButton() {

        saveSettingProjectButton.click();
    }

    public String messageSavedChangesSettings(){
        System.out.println(messageSavedChangesSettings.getText());
        return messageSavedChangesSettings.getText();
    }
}
