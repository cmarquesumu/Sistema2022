package telas;

import componentes.MeuCampoTexto;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaCadastro extends JInternalFrame implements ActionListener {

    protected final int PADRAO = 0;
    protected final int INCLUINDO = 1;
    protected final int ALTERANDO = 2;
    protected final int EXCLUINDO = 3;
    protected final int CONSULTANDO = 4;
    protected int estadoTela = PADRAO;
    private boolean temDadosNaTela = false;
    protected JPanel painelComponentes = new JPanel();
    private JPanel painelBotoes = new JPanel();
    private JButton jbIncluir = new JButton("Incluir");
    private JButton jbAlterar = new JButton("Alterar");
    private JButton jbExcluir = new JButton("Excluir");
    private JButton jbConsultar = new JButton("Consultar");
    private JButton jbConfirmar = new JButton("Confirmar");
    private JButton jbCancelar = new JButton("Cancelar");
    private int qtdeLinhas, qtdeColunas;

    public TelaCadastro(String titulo) {
        super(titulo, true, true, true, true);
        setSize(500, 500);
        getContentPane().add("West",
                painelComponentes);
        getContentPane().add("South",
                painelBotoes);
        painelBotoes.setLayout(
                new GridLayout(1, 6));
        painelComponentes.setLayout(new GridBagLayout());
        painelBotoes.add(jbIncluir);
        painelBotoes.add(jbAlterar);
        painelBotoes.add(jbExcluir);
        painelBotoes.add(jbConsultar);
        painelBotoes.add(jbConfirmar);
        painelBotoes.add(jbCancelar);
        jbIncluir.addActionListener(this);
        jbAlterar.addActionListener(this);
        jbExcluir.addActionListener(this);
        jbConsultar.addActionListener(this);
        jbConfirmar.addActionListener(this);
        jbCancelar.addActionListener(this);

        habilitaBotoes();
    }

    public void adicionaComponente(
            MeuCampoTexto componente, int linha, int coluna,
            int linhas, int colunas) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = linha;
        gbc.gridx = coluna;
        gbc.gridheight = linhas;
        gbc.gridwidth = colunas;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        String textoLabel = "<html><body>" + componente.getNome();
        if (componente.isObrigatorio()) {
            textoLabel = textoLabel + "<font color=red>*</font>";
        }
        textoLabel = textoLabel + ": </body></html>";
        JLabel jl = new JLabel(textoLabel);
        painelComponentes.add(jl, gbc);
        gbc.gridx++;
        painelComponentes.add(componente, gbc);
        int l, c;
        l = linha + (linhas - 1);
        c = coluna + (colunas - 1);
        if (qtdeLinhas < l) {
            qtdeLinhas = l;
        }
        if (qtdeColunas < c) {
            qtdeColunas = c;
        }
    }
    
    public void habilitaBotoes() {
        jbIncluir.setEnabled(estadoTela == PADRAO);
        jbAlterar.setEnabled(estadoTela == PADRAO
                && temDadosNaTela);
        jbExcluir.setEnabled(estadoTela == PADRAO
                && temDadosNaTela);
        jbConsultar.setEnabled(estadoTela == PADRAO);
        jbConfirmar.setEnabled(estadoTela != PADRAO);
        jbCancelar.setEnabled(estadoTela != PADRAO);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jbIncluir) {
            estadoTela = INCLUINDO;
        } else if (ae.getSource() == jbAlterar) {
            estadoTela = ALTERANDO;
        } else if (ae.getSource() == jbExcluir) {
            estadoTela = EXCLUINDO;
        } else if (ae.getSource() == jbConsultar) {
            estadoTela = CONSULTANDO;
        } else if (ae.getSource() == jbConfirmar) {
            estadoTela = PADRAO;
        } else if (ae.getSource() == jbCancelar) {
            estadoTela = PADRAO;
        }
        habilitaBotoes();
    }

}
