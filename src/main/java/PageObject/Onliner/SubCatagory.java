package PageObject.Onliner;

public enum SubCatagory {
    MOBILE_PHONES("catalog-navigation-list__aside-title"),
    VIDEO_GAMES("//*[@class='catalog-navigation-list__aside-item']//*[text()=' Видеоигры ']");
    String subCatagory;

    SubCatagory(String subCatagory) {
        this.subCatagory = subCatagory;
    }

    public String getSubCatagory() {
        return subCatagory;
    }
}
