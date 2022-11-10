package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import pojo.Estado;

public class EstadoDao {
    public final String SQL_INCLUIR = "INSERT INTO ESTADO VALUES (?,?,?,?)";
    public final String SQL_ALTERAR = "UPDATE ESTADO SET NOME_ESTADO = ?, SIGLA_ESTADO = ?, ATIVO_ESTADO = ? WHERE ID_ESTADO = ?";
    public final String SQL_EXCLUIR = "DELETE FROM ESTADO WHERE ID_ESTADO = ?";
    public final String SQL_CONSULTAR = "SELECT * FROM ESTADO WHERE ID_ESTADO = ?";
    public final static String SQL_PESQUISAR = "SELECT * FROM ESTADO ORDER BY NOME_ESTADO";

    public boolean incluir(Estado estado) {
        try {
            estado.setIdEstado(Conexao.getGenerator("G_ESTADO"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, estado.getIdEstado());
            ps.setString(2, estado.getNomeEstado());
            ps.setString(3, estado.getSiglaEstado());
            ps.setString(4, "" + estado.getAtivoEstado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir o Estado.");
            return false;
        }
    }

    public boolean alterar(Estado estado) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setString(1, estado.getNomeEstado());
            ps.setString(2, estado.getSiglaEstado());
            ps.setString(3, "" + estado.getAtivoEstado());
            ps.setInt(4, estado.getIdEstado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o Estado.");
            return false;
        }
    }

    public boolean excluir(Estado estado) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, estado.getIdEstado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o Estado.");
            return false;
        }
    }

    public boolean consultar(Estado estado) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, estado.getIdEstado());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estado.setNomeEstado(rs.getString("NOME_ESTADO"));
                estado.setSiglaEstado(rs.getString("SIGLA_ESTADO"));
                estado.setAtivoEstado(rs.getString("ATIVO_ESTADO").charAt(0));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o Estado.");
            return false;
        }
    }
}

//class TesteEstadoDao {
//
//    public static void main(String args[]) {
//        Estado estado = new Estado();
//        EstadoDao estadoDao = new EstadoDao();
//        String id = JOptionPane.showInputDialog(null, "Informe o Id");
//        String nome = JOptionPane.showInputDialog(null, "Informe o Nome");
//        String sigla = JOptionPane.showInputDialog(null, "Informe a Sigla");
//        String ativo = JOptionPane.showInputDialog(null, "Informe se está ativo", "S");
//
//        estado.setIdEstado(Integer.parseInt(id));
//        estado.setNomeEstado(nome);
//        estado.setSiglaEstado(sigla);
//        estado.setAtivoEstado(ativo.charAt(0));
//
//        String operacao = JOptionPane.showInputDialog(null, "Você quer (I)ncluir, (A)lterar, (E)xcluir ou (C)onsultar?", "C");
//
//        boolean resultado;
//        switch (operacao.toUpperCase().charAt(0)) {
//            case 'I':
//                resultado = estadoDao.incluir(estado);
//                break;
//            case 'A':
//                resultado = estadoDao.alterar(estado);
//                break;
//            case 'E':
//                resultado = estadoDao.excluir(estado);
//                break;
//            case 'C':
//                resultado = estadoDao.consultar(estado);
//                break;
//            default:
//                System.out.println("Operação inválida");
//                return;
//        }
//        if (resultado == true) {
//            System.out.println("OPERAÇÃO " + operacao.toUpperCase() + " efetuada com sucesso!!!");
//            System.out.println("ID: " + estado.getIdEstado());
//            System.out.println("NOME: " + estado.getNomeEstado());
//            System.out.println("SIGLA: " + estado.getSiglaEstado());
//            System.out.println("ATIVO: " + estado.getAtivoEstado());
//        } else {
//            System.out.println("Erro ao tentar executar a operação no banco de dados");
//        }
//    }
//}
