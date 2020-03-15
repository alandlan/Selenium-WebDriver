#language: pt

Funcionalidade: Gerenciamento de Processos.

  Cenario de Fundo:
    Dado O usuario esta na pagina Software Testing.
    E O usuario seleciona o item de menu "processos".

  Cenario: Adicionar Processo com Sucesso.
    E O botao Novo Processo for pressionado.
    E O valor "1" for digitado no campo "processo_vara".
    E O valor "1231456" for digitado no campo "processo_numero_processo".
    E O valor "Guarda" for digitado no campo "processo_natureza".
    E O valor "Joao da Silva x Maria leite" for digitado no campo "processo_partes".
    E O valor "04/03/2020" for digitado no campo "processo_data_entrada".
    E O valor "Agendado" for digitado no campo "processo_status".
    E O Combo Box "processo_urgente" for preenchido com a opcao "Sim".
    E A opcao "Sim" for selecionada no Radio Button Arbitramento.
    Quando O botao "btn-save" for pressionado na pagina de Cadastro de Processo.
    Entao A mensagem "Processo foi criado com sucesso." deve ser exibida.
    Quando O botao Voltar for pressionado.

  Esquema do Cenario: Obter Informacoes de um Processo.
    E O usuario deseja visualizar o registro do processo Id Numero "<id>".
    Quando O botao Mostrar for pressionado na linha do grid.
    Entao O usuario deve receber a mensagem "<mensagem>" como resposta.
    Exemplos:
    | id  | mensagem       |
    | 105 | sucesso        |
    | 000 | não encontrado |

  Cenario: Alterar um Processo com Sucesso.
    E O usuario deseja visualizar o registro do processo Id Numero "105".
    E O botao Alterar Processo for pressionado na linha do grid.
    E O valor "1" for digitado no campo "processo_vara".
    E O valor "123.145-2006.25" for digitado no campo "processo_numero_processo".
    E O valor "Guarda" for digitado no campo "processo_natureza".
    E O valor "Joao da Silva x Maria leite" for digitado no campo "processo_partes".
    E O valor "04/03/2020" for digitado no campo "processo_data_entrada".
    E O valor "Agendado" for digitado no campo "processo_status".
    E O Combo Box "processo_urgente" for preenchido com a opcao "Sim".
    E A opcao "Sim" for selecionada no Radio Button Arbitramento.
    Quando O botao "btn-save" for pressionado na pagina de Alteracao de Processo.
    Entao A mensagem "Processo atualizado com sucesso." deve ser exibida.

  Cenario: Excluir um Processo com Sucesso.
    E O usuario deseja visualizar o registro do processo Id Numero "105".
    Quando O botao Excluir for pressionado na linha do grid.