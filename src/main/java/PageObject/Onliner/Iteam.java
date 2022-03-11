package PageObject.Onliner;

public enum Iteam {
    PHONES("//*[@class='catalog-navigation-list__dropdown-data']//*[text()=' Смартфоны ']"),
    GAMING_CONSOLS("//*[@class='catalog-navigation-list__dropdown-data']//*[text()=' Игровые приставки ']");
    String iteam;

    Iteam(String iteam) {
        this.iteam = iteam;
    }

    public String getIteam() {
        return iteam;
    }
}

