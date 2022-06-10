package telas;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaCadastro extends JFrame {
    private JPanel painelBotoes =
            new JPanel();

    public TelaCadastro(String titulo) {
        super(titulo);
        setSize(500, 500);
        getContentPane().add("North",
                painelBotoes);
        painelBotoes.setLayout(
                new GridLayout(1, 6));
        painelBotoes.add(new JButton("Incluir"));
        painelBotoes.add(new JButton("Alterar"));
        painelBotoes.add(new JButton("Excluir"));
        painelBotoes.add(new JButton("Consultar"));
        painelBotoes.add(new JButton("Confirmar"));
        painelBotoes.add(new JButton("Cancelar"));
        
                
    }
}