package telas;

import componentes.MeuCampoTexto;

public class TelaCadastroPais extends TelaCadastro {
   private MeuCampoTexto jtfCodigo = new MeuCampoTexto("Código", 5, true);
   private MeuCampoTexto jtfNome = new MeuCampoTexto("Nome", 20, true);
   private MeuCampoTexto jtfAtivo = new MeuCampoTexto("Ativo", 2, false);
   
   public TelaCadastroPais() {
       super("Cadastro de País");
       adicionaCampo(jtfCodigo, 1, 2, 1, 1);
       adicionaCampo(jtfNome, 2, 2, 1, 3);
       adicionaCampo(jtfAtivo, 1, 4, 1, 1);
//       mostraLinhasColunasComponentes();
       habilitaCampos(false);
       pack();
       setVisible(true);
   }    
}