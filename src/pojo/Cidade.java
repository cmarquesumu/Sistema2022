package pojo;

public class Cidade {
    private int idCidade;
    private String nomeCidade;
    private int idEstado;
//   private Estado estado = new Estado();
    private char ativoCidade;

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public char getAtivoCidade() {
        return ativoCidade;
    }

    public void setAtivoCidade(char ativoCidade) {
        this.ativoCidade = ativoCidade;
    }
}
