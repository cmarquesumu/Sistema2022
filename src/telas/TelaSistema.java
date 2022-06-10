package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaSistema extends JFrame implements ActionListener {

    private JMenuBar jmb = new JMenuBar();
    private JMenu jmCadastros = new JMenu("Cadastros");
    private JMenu jmMovimentos = new JMenu("Movimentos");
    private JMenu jmRelatorios = new JMenu("Relatórios");
    private JMenuItem jmiPais = new JMenuItem("País");
    private JMenuItem jmiEstado = new JMenuItem("Estado");
    private JMenuItem jmiCidade = new JMenuItem("Cidade");
    private JMenuItem jmiFornecedor = new JMenuItem("Fornecedor");

    public TelaSistema(String titulo) {
        setTitle(titulo);
        setSize(400, 300);
        setJMenuBar(jmb);
        jmb.add(jmCadastros);
        jmb.add(jmMovimentos);
        jmb.add(jmRelatorios);
        adicionarItemMenu(jmCadastros, jmiPais);
        adicionarItemMenu(jmCadastros, jmiEstado);
        adicionarItemMenu(jmCadastros, jmiCidade);
        adicionarItemMenu(jmCadastros, jmiFornecedor);
        setVisible(true);
        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
    }
    
    private void adicionarItemMenu(JMenu menu, JMenuItem itemMenu) {
        menu.add(itemMenu);
        itemMenu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jmiPais) {
            TelaCadastroPais telaCadastroPais = 
                    new TelaCadastroPais();
        } else if (ae.getSource() == jmiEstado) {
            TelaCadastroEstado telaCadastroEstado = 
                    new TelaCadastroEstado();
        } else if (ae.getSource() == jmiCidade) {
            TelaCadastroCidade telaCadastroCidade = 
                    new TelaCadastroCidade();
        } else if (ae.getSource() == jmiFornecedor) {
            TelaCadastroFornecedor telaCadastroFornecedor = 
                    new TelaCadastroFornecedor();
        }
    }
}
