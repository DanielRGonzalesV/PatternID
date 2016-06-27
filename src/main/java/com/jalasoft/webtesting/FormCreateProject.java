package com.jalasoft.webtesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by danielgonzales on 6/15/2016.
 */
public class FormCreateProject extends PagesPivotal {

    @FindBy(css= ".tc_select_account_name")
    private WebElement accountListBox;

    @FindBy(xpath = ".//*[@id='tc_public_project']/input")
    private WebElement projectPublicCheckBox;

    @FindBy(className = "tc_form_input")
    private WebElement projectNameTextField;

    @FindBy(className = "tc_form_select")
    private WebElement accountListBoxOption;

    @FindBy(className = "tc_select_account_name")
    private WebElement accountOwnerProjectLisBoxOption;

    @FindBy(css = ".tc_button.tc_button_submit")
    private WebElement createProjectButton;

    public void setProjectNameTextField(String nameNewProject) {
        projectNameTextField.clear();
        projectNameTextField.sendKeys(nameNewProject);
    }

    public void clickListBox() {
        accountListBoxOption.click();
    }


    public void selectAccountOfListBox() {

        if(!accountListBox.isSelected()){
            accountListBox.click();
        }
    }

    public void checkProjectPublicCheckBox() {

        if(!projectPublicCheckBox.isSelected()){
            projectPublicCheckBox.click();
        }
    }

    public Project clickCreateButton() {
        createProjectButton.click();
        return new Project();
    }

}
