package br.csi.farmaspring.dao;

import br.csi.farmaspring.model.Permissao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PermDao {
    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ArrayList<Permissao> listPerm(){
        ArrayList<Permissao> permissaos = new ArrayList<Permissao>();

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = " SELECT * FROM permissao";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()){
                Permissao p = new Permissao(resultSet.getInt("id_permissao"), resultSet.getString("nome_permissao"));
                permissaos.add(p);
                System.out.println(p.getNome());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return permissaos;
    }
}
