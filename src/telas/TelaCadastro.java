package telas;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class TelaCadastro extends JInternalFrame {
    private JPanel painelBotoes =
            new JPanel();
    private JButton jbIncluir = new JButton("Incluir");
    private JButton jbAlterar = new JButton("Alterar");
    private JButton jbExcluir = new JButton("Excluir");
    private JButton jbConsultar = new JButton("Consultar");
    private JButton jbConfirmar = new JButton("Confirmar");
    private JButton jbCancelar = new JButton("Cancelar");
    
    public TelaCadastro(String titulo) {
        super(titulo, true, true, true, true);
        setSize(500, 500);
        getContentPane().add("South",
                painelBotoes);
        painelBotoes.setLayout(
                new GridLayout(1, 6));
        painelBotoes.add(jbIncluir);
        painelBotoes.add(jbAlterar);
        painelBotoes.add(jbExcluir);
        painelBotoes.add(jbConsultar);
        painelBotoes.add(jbConfirmar);
        painelBotoes.add(jbCancelar);  
        habilitaBotoes();
    }
    
    public void habilitaBotoes() {
        jbIncluir.setEnabled(true);
        jbAlterar.setEnabled(false);
        jbExcluir.setEnabled(false);
        jbConsultar.setEnabled(true);
        jbConfirmar.setEnabled(false);
        jbCancelar.setEnabled(false);
    }
}