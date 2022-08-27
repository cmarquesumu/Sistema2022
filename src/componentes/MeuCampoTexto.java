package componentes;

import javax.swing.JTextField;

public class MeuCampoTexto extends JTextField {

    private String nome;
    private boolean  obrigatorio;

    public MeuCampoTexto(String nome, int tamanho,
            boolean obrigatorio) {
        super(tamanho);
        this.nome = nome;
        this.obrigatorio = obrigatorio;
    }
    
    public String getNome() {
        return nome;
    }
    
    public boolean isObrigatorio() {
        return obrigatorio;
    }
}
