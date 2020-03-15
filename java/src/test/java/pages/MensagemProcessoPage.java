package pages;
import support.DriverQA;

public class MensagemProcessoPage {
    private DriverQA driver;

    public MensagemProcessoPage(DriverQA stepDriver) {
        driver = stepDriver;
    }

    public String Sucesso() {
        return driver.getText("notice");
    }

    public void Voltar() {
        driver.click(".ls-btn-primary-danger", "css");
    }
}
