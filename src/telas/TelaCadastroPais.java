package telas;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastroPais extends TelaCadastro {
   private JLabel jlCodigo = new JLabel("Código: ");
   private JLabel jlNome = new JLabel("Nome: ");
   private JLabel jlAtivo = new JLabel("Ativo: ");

   private JTextField jtfCodigo = new JTextField(5);
   private JTextField jtfNome = new JTextField(20);
   private JTextField jtfAtivo = new JTextField(2);
   
   public TelaCadastroPais() {
       super("Cadastro de País");
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.gridy = 1;
       gbc.gridx = 1;
       gbc.gridheight = 1;
       gbc.gridwidth = 1;
       gbc.anchor = GridBagConstraints.WEST;
       
       painelComponentes.add(jlCodigo, gbc);
       gbc.gridx = 2;
       painelComponentes.add(jtfCodigo, gbc);
       gbc.gridy = 2;
       gbc.gridx = 1;
       painelComponentes.add(jlNome, gbc);
       gbc.gridx = 2;
       gbc.gridwidth = 2;
       painelComponentes.add(jtfNome, gbc);
       gbc.gridwidth = 1;
       gbc.gridy = 1;
       gbc.gridx = 3;
       painelComponentes.add(jlAtivo, gbc);
 //      painelComponentes.add(jtfAtivo);
       setVisible(true);
   }    

}
