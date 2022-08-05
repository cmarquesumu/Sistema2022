package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaSistema extends JFrame implements ActionListener {
    private JDesktopPane jdp = new JDesktopPane();
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
        getContentPane().add(jdp);
        jdp.setBackground(Color.yellow);
        setJMenuBar(jmb);
        jmb.add(jmCadastros);
        jmb.add(jmMovimentos);
        jmb.add(jmRelatorios);
        adicionarItemMenu(jmCadastros, jmiPais);
        adicionarItemMenu(jmCadastros, jmiEstado);
        adicionarItemMenu(jmCadastros, jmiCidade);
        adicionarItemMenu(jmCadastros, jmiFornecedor);
        setExtendedState(MAXIMIZED_BOTH);
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
            jdp.add(telaCadastroPais);
        } else if (ae.getSource() == jmiEstado) {
            TelaCadastroEstado telaCadastroEstado = 
                    new TelaCadastroEstado();
            jdp.add(telaCadastroEstado);
        } else if (ae.getSource() == jmiCidade) {
            TelaCadastroCidade telaCadastroCidade = 
                    new TelaCadastroCidade();
            jdp.add(telaCadastroCidade);
        } else if (ae.getSource() == jmiFornecedor) {
            TelaCadastroFornecedor telaCadastroFornecedor = 
                    new TelaCadastroFornecedor();
            jdp.add(telaCadastroFornecedor);
        }
    }
}
