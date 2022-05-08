package hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    @When("I click on {string} button in Header")
    public void openHeaderItem(String item) {
        homePage.getHeaderMenu().clickNavigationBarItem(item);
    }

    @And("I click on {string} button in Service dropdown")
    public void openDropdownItem(String item) {
        homePage.getHeaderMenu().clickNavigationBarItem("SERVICE");
        homePage.clickDropdownMenu(item);
    }

    @And("I select {string} checkboxes in main form on Different Elements page")
    public void clickCheckboxDiffEl(String checkbox) {
        diffElement.clickCheckbox(checkbox);
    }

    @And("I select radio buttons {string} in main form on Different Elements page")
    public void clickRadioboxDiffEl(String radiobox) {
        diffElement.clickRadiobox(radiobox);
    }

    @And("I select {string} in dropdown in main form on Different Elements page")
    public void clickDropdownDiffEl(String dropdown) {
        diffElement.clickOption(dropdown);
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectCheckboxOnUserTablePage(String username) {
        userTable.clickCheckboxByUserName(username);
    }
}
