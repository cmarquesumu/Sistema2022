package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import pojo.Cidade;

public class CidadeDao {

    public final String SQL_INCLUIR = "INSERT INTO CIDADE VALUES (?,?,?,?)";
    public final String SQL_ALTERAR = "UPDATE CIDADE SET NOME_CIDADE = ?, ID_ESTADO = ?, ATIVO_CIDADE = ? WHERE ID_CIDADE = ?";
    public final String SQL_EXCLUIR = "DELETE FROM CIDADE WHERE ID_CIDADE = ?";
    public final String SQL_CONSULTAR = "SELECT * FROM CIDADE WHERE ID_CIDADE = ?";
    public static final String SQL_PESQUISAR = "SELECT ID_CIDADE, NOME_CIDADE, SIGLA_ESTADO, ATIVO_CIDADE FROM CIDADE JOIN ESTADO ON CIDADE.ID_ESTADO = ESTADO.ID_ESTADO ORDER BY NOME_CIDADE";
    
    public boolean incluir(Cidade cidade) {
        try {
            cidade.setIdCidade(Conexao.getGenerator("G_CIDADE"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, cidade.getIdCidade());
            ps.setString(2, cidade.getNomeCidade());
            ps.setInt(3, cidade.getIdEstado());
            ps.setString(4, "" + cidade.getAtivoCidade());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir a Cidade.");
            return false;
        }
    }

    public boolean alterar(Cidade cidade) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setString(1, cidade.getNomeCidade());
            ps.setInt(2, cidade.getIdEstado());
            ps.setString(3, "" + cidade.getAtivoCidade());
            ps.setInt(4, cidade.getIdCidade());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a Cidade.");
            return false;
        }
    }

    public boolean excluir(Cidade cidade) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, cidade.getIdCidade());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a Cidade.");
            return false;
        }
    }

    public boolean consultar(Cidade cidade) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, cidade.getIdCidade());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cidade.setNomeCidade(rs.getString("NOME_CIDADE"));
                cidade.setIdEstado(rs.getInt("ID_ESTADO"));
                cidade.setAtivoCidade(rs.getString("ATIVO_CIDADE").charAt(0));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar a Cidade.");
            return false;
        }
    }
}

//class TesteCidadeDao {
//
//    public static void main(String args[]) {
//        Cidade cidade = new Cidade();
//        CidadeDao cidadeDao = new CidadeDao();
//        String id = JOptionPane.showInputDialog(null, "Informe o Id");
//        String nome = JOptionPane.showInputDialog(null, "Informe o Nome");
//        String idEstado = JOptionPane.showInputDialog(null, "Informe o Id do Estado");
//        String ativo = JOptionPane.showInputDialog(null, "Informe se está ativo", "S");
//
//        cidade.setIdCidade(Integer.parseInt(id));
//        cidade.setNomeCidade(nome);
//        cidade.setIdEstado(Integer.parseInt("0" + idEstado));
//        cidade.setAtivoCidade(ativo.charAt(0));
//
//        String operacao = JOptionPane.showInputDialog(null, "Você quer (I)ncluir, (A)lterar, (E)xcluir ou (C)onsultar?", "C");
//
//        boolean resultado;
//        switch (operacao.toUpperCase().charAt(0)) {
//            case 'I':
//                resultado = cidadeDao.incluir(cidade);
//                break;
//            case 'A':
//                resultado = cidadeDao.alterar(cidade);
//                break;
//            case 'E':
//                resultado = cidadeDao.excluir(cidade);
//                break;
//            case 'C':
//                resultado = cidadeDao.consultar(cidade);
//                break;
//            default:
//                System.out.println("Operação inválida");
//                return;
//        }
//        if (resultado == true) {
//            System.out.println("OPERAÇÃO " + operacao.toUpperCase() + " efetuada com sucesso!!!");
//            System.out.println("ID: " + cidade.getIdCidade());
//            System.out.println("NOME: " + cidade.getNomeCidade());
//            System.out.println("SIGLA: " + cidade.getIdEstado());
//            System.out.println("ATIVO: " + cidade.getAtivoCidade());
//        } else {
//            System.out.println("Erro ao tentar executar a operação no banco de dados");
//        }
//    }
//}
