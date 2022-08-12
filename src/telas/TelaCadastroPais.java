package telas;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastroPais extends TelaCadastro {
   private JLabel jlNome = new JLabel("Nome: ");
   private JTextField jtfNome = new JTextField(20);
   
   public TelaCadastroPais() {
       super("Cadastro de País");
       painelComponentes.add(jlNome);
       painelComponentes.add(jtfNome);
       habilitaComponentes();
       setVisible(true);
   }    
   
   private void habilitaComponentes() {
       jtfNome.setEnabled(estadoTela == INCLUINDO ||
                          estadoTela == ALTERANDO);
   }
}
