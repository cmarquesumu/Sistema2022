package telas;

import componentes.MeuCampoSimNao;
import componentes.MeuCampoTexto;
import dao.EstadoDao;
import pojo.Estado;

public class TelaCadastroEstado extends TelaCadastro {

    private Estado estado = new Estado();
    private EstadoDao estadoDao = new EstadoDao();
    private MeuCampoTexto mctCodigo = new MeuCampoTexto("Código", 5, false) {
        @Override
        public void setEnabled(boolean status) {
            super.setEnabled(false);
        }
    };
    private MeuCampoTexto mctNome = new MeuCampoTexto("Nome", 20, true);
    private MeuCampoTexto mctSigla = new MeuCampoTexto("Sigla", 2, true);
    private MeuCampoSimNao mcsnAtivo = new MeuCampoSimNao("Ativo");

    public TelaCadastroEstado() {
        super("Cadastro de Estado");
        adicionaCampo(mctCodigo, 1, 1, 1, 1);
        adicionaCampo(mctNome, 2, 1, 1, 1);
        adicionaCampo(mctSigla, 3, 1, 1, 1);
        adicionaCampo(mcsnAtivo, 4, 1, 1, 1);
        habilitaCampos(false);
        pack();
        setVisible(true);
    }

    public void setaPojo() {
        estado.setIdEstado(Integer.parseInt("0" + mctCodigo.getValor()));
        estado.setNomeEstado(mctNome.getValor());
        estado.setSiglaEstado(mctSigla.getValor());
        estado.setAtivoEstado(mcsnAtivo.getValor().charAt(0));
    }

    @Override
    public boolean incluir() {
        setaPojo();
        boolean resultado = estadoDao.incluir(estado);
        if (resultado == true) {
            mctCodigo.setText("" + estado.getIdEstado());
        }
        return resultado;
    }

    @Override
    public boolean alterar() {
        setaPojo();
        return estadoDao.alterar(estado);
    }

    @Override
    public boolean excluir() {
        setaPojo();
        return estadoDao.excluir(estado);
    }

    @Override
    public boolean consultar() {
        new TelaConsulta(this,
                "Consulta de Estado",
                new String[]{"Código", "Nome", "Sigla", "Ativo"},
                EstadoDao.SQL_PESQUISAR);
        return true;
    }

    @Override
    public void preencherDados(int id) {
      estado.setIdEstado(id);
      estadoDao.consultar(estado);
      mctCodigo.setValor("" + estado.getIdEstado());
      mctNome.setValor(estado.getNomeEstado());
      mctSigla.setValor(estado.getSiglaEstado());
      mcsnAtivo.setValor(estado.getAtivoEstado() == 'S' ? "Sim" : "Não");
      
//      if (estado.getAtivoEstado() == 'S') {
//          mcsnAtivo.setValor("Sim");
//      } else {
//          mcsnAtivo.setValor("Não");
//      }
      super.preencherDados(id);
    }
}
