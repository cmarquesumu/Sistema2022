package pojo;

public class Estado {
   private int idEstado;
   private String nomeEstado;
   private String siglaEstado;
   private char ativoEstado;

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public char getAtivoEstado() {
        return ativoEstado;
    }

    public void setAtivoEstado(char ativoEstado) {
        this.ativoEstado = ativoEstado;
    }
}
