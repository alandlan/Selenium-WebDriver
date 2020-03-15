package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.*;
import org.junit.Assert;
import pages.*;
import support.BaseSteps;
import support.RESTSupport;
import groovy.json.internal.LazyMap;


public class ProcessosSteps extends BaseSteps {

    //--> Inicia as Instâncias de classes que representam as páginas da aplicação web que será testada.
    private HomePage principal = new HomePage(driver);
    private ProcessoListaPage listaProcessos = new ProcessoListaPage(driver);
    private CadastroProcessoPage cadastroProcesso = new CadastroProcessoPage(driver);
    private MensagemProcessoPage mensagensProcesso = new MensagemProcessoPage(driver);

    //--> Métodos para a página principal.
    @Dado("^O usuario esta na pagina Software Testing.$")
    public void oUsuarioEstaNaPaginaSoftwareTesting() { principal.AcessarPagina(); }

    @E("^O usuario seleciona o item de menu \"([^\"]*)\".$")
    public void oUsuarioSelecionaOItemDeMenu(String itemMenu) throws Throwable { principal.SelecionarMenu(itemMenu); }


    //--> Métodos para a pagina de consulta de Processos (página do grid com os botões do CRUD).
    @E("^O botao Novo Processo for pressionado.$")
    public void oBotaoNovoProcessoForPressionado() {
        listaProcessos.IncluirProcesso();
    }

    @E("^O usuario deseja visualizar o registro do processo Id Numero \"([^\"]*)\".$")
    public void oUsuarioDesejaVisualizarORegistroDoProcessoIdNumero(String valor) throws Throwable {
        listaProcessos.CarregarProcesso(valor);
    }

    @Quando("^O botao Alterar Processo for pressionado na linha do grid.$")
    public void oBotaoAlterarProcessoForPressionado() {
        listaProcessos.AlterarProcesso();
    }

    @Quando("^O botao Mostrar for pressionado na linha do grid.$")
    public void oBotaoMostrarForPressionado() {
        listaProcessos.MostrarProcesso();
    }

    @Quando("^O botao Excluir for pressionado na linha do grid.$")
    public void oBotaoExcluirForPressionadoNaLinhaDoGrid() {
        String CaminhoUrl = CadastroProcessoPage.ObterUrl() + listaProcessos.ObterUltimoProcesso() + ".json";
        RESTSupport.executeDelete(CaminhoUrl);
    }

    //--> Métodos para a página do Cadastro de Processo.
    @E("^O valor \"([^\"]*)\" for digitado no campo \"([^\"]*)\".$")
    public void oValorForDigitadoNoCampo(String valor, String campo) throws Throwable {
        cadastroProcesso.PreencherCampo(campo, valor);
    }

    @E("^O Combo Box \"([^\"]*)\" for preenchido com a opcao \"([^\"]*)\".$")
    public void oComboBoxForPreenchidoComAOpcao(String campo, String valor) throws Throwable {
        cadastroProcesso.SelecionarComboBox(campo, valor);
    }

    @E("^A opcao \"([^\"]*)\" for selecionada no Radio Button Arbitramento.$")
    public void aOpcaoForSelecionadaNoRadioButtonArbitramento(String valor) throws Throwable {
        cadastroProcesso.SelecionarRadioButton(valor);
    }

    @Quando("^O botao \"([^\"]*)\" for pressionado na pagina de Cadastro de Processo.$")
    public void oBotaoForPressionadoNaPaginaDeCadastroDeProcesso(String idBotao) throws Throwable {
        cadastroProcesso.Salvar(idBotao);
    }

    //--> Métodos da página de alteração de processos.
    @Quando("^O botao \"([^\"]*)\" for pressionado na pagina de Alteracao de Processo.$")
    public void oBotaoForPressionadoNaPaginaDeAlteracaoDeProcesso(String valor) throws Throwable {
        String CaminhoUrl = CadastroProcessoPage.ObterUrl() + listaProcessos.ObterUltimoProcesso() + ".json";
        RESTSupport.executePut(CaminhoUrl, CadastroProcessoPage.ObterListaCampos());
    }

    //--> Métodos para a página de Mensagens
    @Entao("^A mensagem \"([^\"]*)\" deve ser exibida.$")
    public void aMensagemDeveSerExibida(String mensagem) throws Throwable {
        Assert.assertEquals(mensagem, mensagensProcesso.Sucesso());
    }

    @Quando("^O botao Voltar for pressionado.$")
    public void oBotaoVoltarForPressionado() {
        mensagensProcesso.Voltar();
    }

    @Entao("^O usuario deve receber a mensagem \"([^\"]*)\" como resposta.$")
    public void oUsuarioDeveReceberAMensagemComoResposta(String mensagem) throws Throwable {
        LazyMap MsgJson = new LazyMap();

        MsgJson.put("success", 200);
        MsgJson.put("save with success", 201);
        MsgJson.put("no content", 204);
        MsgJson.put("not found", 404);
        MsgJson.put("unauthorized", 401);

        MsgJson.put("sucesso", 200);
        MsgJson.put("salvo com sucesso", 201);
        MsgJson.put("sem informação", 204);
        MsgJson.put("não encontrado", 404);
        MsgJson.put("não autorizado", 401);

        Assert.assertEquals(MsgJson.get(mensagem),RESTSupport.getResponseCode());
    }
}
