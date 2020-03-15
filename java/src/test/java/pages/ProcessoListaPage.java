package pages;

import support.DriverQA;

public class ProcessoListaPage {
    private DriverQA driver;
    private String ultimoID;

    public ProcessoListaPage(DriverQA stepDriver) {
        driver = stepDriver;
    }

    public void IncluirProcesso() {
        driver.click("btn-novo");
    }

    public String ObterUltimoProcesso() {
        return ultimoID;
    }

    public void CarregarProcesso(String valor) {
        ultimoID = valor;
    }

    public void AlterarProcesso() {
        driver.click(".ls-btn", "css");
    }

    public void MostrarProcesso() {
        driver.click(".ls-btn-primary", "css");
    }
}
