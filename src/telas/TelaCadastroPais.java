package telas;

import componentes.MeuCampoTexto;

public class TelaCadastroPais extends TelaCadastro {
   private MeuCampoTexto jtfCodigo = new MeuCampoTexto("Código", 5, true);
   private MeuCampoTexto jtfNome = new MeuCampoTexto("Nome", 20, true);
   private MeuCampoTexto jtfAtivo = new MeuCampoTexto("Ativo", 2, false);
   
   public TelaCadastroPais() {
       super("Cadastro de País");
       adicionaComponente(jtfCodigo, 1, 2, 1, 1);
       adicionaComponente(jtfNome, 2, 2, 1, 3);
       adicionaComponente(jtfAtivo, 1, 4, 1, 1);
//       mostraLinhasColunasComponentes();
       pack();
       setVisible(true);
   }    
}