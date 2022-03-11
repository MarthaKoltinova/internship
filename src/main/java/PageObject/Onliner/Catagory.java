package PageObject.Onliner;

public enum Catagory {
    ELECTRONICS("//*[@class='catalog-navigation-classifier__item-title']//*[text()='Электроника']");
    String catagory;

    Catagory(String catagory) {
        this.catagory = catagory;
    }

    public String getCatagory() {
        return catagory;
    }
}
