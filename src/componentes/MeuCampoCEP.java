package componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

public class MeuCampoCEP extends JFormattedTextField implements MeuComponente {

    private String nome;
    private boolean obrigatorio;

    public MeuCampoCEP(String nome, boolean obrigatorio) {
        try {
            this.nome = nome;
            this.obrigatorio = obrigatorio;
            adicionaFocusListener();
            MaskFormatter mf = new MaskFormatter("#####-###");
            mf.setPlaceholderCharacter('_');
            mf.install(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public void adicionaFocusListener() {
        Border bordaPadrao = getBorder();
        Color corPadrao = getBackground();
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
                setBackground(new Color(200, 250, 255));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                setBorder(bordaPadrao);
                setBackground(corPadrao);
            }
        });
    }

    @Override
    public String getValor() {
        return getText();
    }
    
    @Override
    public void setValor(Object valor) {
        setText((String) valor);
    }

    @Override
    public boolean isVazio() {
        return getValor().equals("_____-___");
    }

    @Override
    public boolean isValido() {
//       int tamanho = getValor().replace("-", "").replace("_", "").length();
//       if (tamanho == 8) {
//           return true;
//       } else {
//           return false;
//       }

//        return getValor().replace("-", "").replace("_", "").length() == 8;
        
       String v1 = getValor();
       String v2 = v1.replace("-", "");
       String v3 = v2.replace("_", "");
       int n = v3.length();
       if (n == 8) {
           return true;
       } else {
           return false;
       }
    }

    @Override
    public void limpar() {
        setText("");
    }
}
