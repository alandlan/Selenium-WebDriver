package pages;
import support.DriverQA;
import groovy.json.internal.LazyMap;

public class CadastroProcessoPage {
    private DriverQA driver;
    private static final String url = "http://agapito-server.herokuapp.com/processos/";
    private static LazyMap listaCamposJson = new LazyMap();

    public CadastroProcessoPage(DriverQA stepDriver) {
        driver = stepDriver;
    }

    public static String ObterUrl() {
        return url;
    }

    public static LazyMap ObterListaCampos() {
        return listaCamposJson;
    }

    public void PreencherCampo(String campo, String valor) {
        driver.sendKeys(valor, campo);
    }

    public void SelecionarComboBox(String campo, String valor) {
        driver.selectByText(valor, campo);
    }

    public void SelecionarRadioButton(String valor) {
        if (valor.equals("Sim")) {
            driver.click("processo_arbitramento_s");
        } else {
            driver.click("processo_arbitramento_n");
        }
    }

    public void Salvar(String idBotao) {
        driver.click(idBotao);
    }
}
