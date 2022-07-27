package br.csi.farmaspring.dao;

import br.csi.farmaspring.model.Funcionario;
import br.csi.farmaspring.model.Permissao;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Funcionario getLogin(String cpf) {
        Funcionario func = null;

        try (Connection connection = new ConectaDB().getConexao()) {
            this.sql = " SELECT * FROM funcionario, permissao where cpffun = ? and funcionario.id_permissao = permissao.id_permissao";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, cpf);
            this.resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()){
                func = new Funcionario();
                func.setCodfun(resultSet.getInt("codfun"));
                func.setNomfun(resultSet.getString("nomfun"));
                func.setCpffun(resultSet.getString("cpffun"));
                func.setSenha(resultSet.getString("senha"));
                Permissao p = new Permissao(resultSet.getInt("id_permissao"), resultSet.getString("nome_permissao"));
                func.setPermissao(p);
            }

        } catch (PSQLException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return func;
    }
}
