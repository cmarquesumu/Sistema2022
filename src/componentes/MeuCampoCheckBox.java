package componentes;

import javax.swing.JCheckBox;

public class MeuCampoCheckBox extends JCheckBox implements MeuComponente {
    private String nome;
    
    public MeuCampoCheckBox(String nome) {
        this.nome = nome;
        setSelected(true);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public boolean isObrigatorio() {
        return true;
    }

    @Override
    public String getValor() {
        if (isSelected()) {
            return "Sim";
        } else {
            return "Não";
        }
    }
    
    @Override
    public void setValor(Object valor) {
        setSelected((boolean) valor);
    }

    @Override
    public boolean isVazio() {
        return false;
    }

    @Override
    public boolean isValido() {
        return true;
    }

    @Override
    public void limpar() {
        setSelected(false);
    }
}