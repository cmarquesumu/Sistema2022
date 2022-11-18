package telas;

import componentes.MeuCampoDBComboBox;
import componentes.MeuCampoSimNao;
import componentes.MeuCampoTexto;
import dao.CidadeDao;
import dao.EstadoDao;
import pojo.Cidade;

public class TelaCadastroCidade extends TelaCadastro {
    private Cidade cidade = new Cidade();
    private CidadeDao cidadeDao = new CidadeDao();
    private MeuCampoTexto mctCodigo = new MeuCampoTexto("Código", 5, false) {
        @Override
        public void setEnabled(boolean status) {
            super.setEnabled(false);
        }
    };
    private MeuCampoTexto mctNome = new MeuCampoTexto("Nome", 20, true);
    private MeuCampoDBComboBox mcbEstado = new MeuCampoDBComboBox(true, EstadoDao.SQL_COMBOBOX, "Estado");
    private MeuCampoSimNao mcsnAtivo = new MeuCampoSimNao("Ativo");

    
    public TelaCadastroCidade() {
       super("Cadastro de Cidade");
        adicionaCampo(mctCodigo, 1, 1, 1, 1);
        adicionaCampo(mctNome, 2, 1, 1, 1);
        adicionaCampo(mcbEstado, 3, 1, 1, 1);
        adicionaCampo(mcsnAtivo, 4, 1, 1, 1);
        habilitaCampos(false);
        pack();
        setVisible(true);
   }    

    public void setaPojo() {
        cidade.setIdCidade(Integer.parseInt("0" + mctCodigo.getValor()));
        cidade.setNomeCidade(mctNome.getValor());
        cidade.setIdEstado(Integer.parseInt(mcbEstado.getValor()));
        cidade.setAtivoCidade(mcsnAtivo.getValor().charAt(0));
    }

    @Override
    public boolean incluir() {
        setaPojo();
        boolean resultado = cidadeDao.incluir(cidade);
        if (resultado == true) {
            mctCodigo.setText("" + cidade.getIdCidade());
        }
        return resultado;
    }

    @Override
    public boolean alterar() {
        setaPojo();
        return cidadeDao.alterar(cidade);
    }

    @Override
    public boolean excluir() {
        setaPojo();
        return cidadeDao.excluir(cidade);
    }

    @Override
    public boolean consultar() {
        new TelaConsulta(this,
                "Consulta de Cidade",
                new String[]{"Código", "Nome", "Estado", "Ativo"},
                CidadeDao.SQL_PESQUISAR);
        return true;
    }

    @Override
    public void preencherDados(int id) {
      cidade.setIdCidade(id);
      cidadeDao.consultar(cidade);
      mctCodigo.setValor("" + cidade.getIdCidade());
      mctNome.setValor(cidade.getNomeCidade());
      mcbEstado.setValor(cidade.getIdEstado());
      mcsnAtivo.setValor(cidade.getAtivoCidade() == 'S' ? "Sim" : "Não");
      
//      if (cidade.getAtivoCidade() == 'S') {
//          mcsnAtivo.setValor("Sim");
//      } else {
//          mcsnAtivo.setValor("Não");
//      }
      super.preencherDados(id);
    }
}
