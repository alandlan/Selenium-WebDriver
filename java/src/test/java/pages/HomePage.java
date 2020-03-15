package pages;

import support.DriverQA;

public class HomePage {
    private DriverQA driver;

    public HomePage(DriverQA stepDriver) {
        driver = stepDriver;
    }

    public void AcessarPagina() {
        driver.openURL("http://agapito-server.herokuapp.com/");
    }

    public void SelecionarMenu(String itemMenu) {
        driver.click(itemMenu);
    }
}
