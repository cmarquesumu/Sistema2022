package telas;

import componentes.MeuCampoCEP;
import componentes.MeuCampoComboBox;
import componentes.MeuCampoTexto;

public class TelaCadastroPais extends TelaCadastro {
   private MeuCampoTexto mctCodigo = new MeuCampoTexto("Código", 5, true);
   private MeuCampoTexto mctNome = new MeuCampoTexto("Nome", 20, true);
   private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);
   private MeuCampoCEP mccCEP = new MeuCampoCEP("CEP", true);
   
   public TelaCadastroPais() {
       super("Cadastro de País");
       adicionaCampo(mctCodigo, 1, 2, 1, 1);
       adicionaCampo(mctNome, 2, 2, 1, 3);
       adicionaCampo(mcsnAtivo, 1, 4, 1, 1);
       adicionaCampo(mccCEP, 3, 1, 1, 1);
//       mostraLinhasColunasComponentes();
       habilitaCampos(false);
       pack();
       setVisible(true);
   }    

    @Override
    public boolean incluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean alterar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void preencherDados(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}