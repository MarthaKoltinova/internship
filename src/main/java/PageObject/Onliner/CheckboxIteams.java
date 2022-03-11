package PageObject.Onliner;

public enum CheckboxIteams {
    HONOR("//*[@class='schema-filter__label']//span[text() ='Производитель']//ancestor::div[@class ='schema-filter__fieldset']//li//label[@class='schema-filter__checkbox-item']//*[text()='HONOR']");
    String checkboxIteams;

    CheckboxIteams(String checkboxIteams) {
        this.checkboxIteams = checkboxIteams;
    }

    public String getCheckboxIteams() {
        return checkboxIteams;
    }
}


