package br.csi.farmaspring.dao;

import br.csi.farmaspring.model.Funcionario;
import br.csi.farmaspring.model.Permissao;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FunDao {
    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Funcionario getFuncionario(String cpf) {
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

    public ArrayList<Funcionario> listFun(){
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = " SELECT * FROM funcionario, permissao where funcionario.id_permissao = permissao.id_permissao";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()){
                Funcionario func = new Funcionario();
                func.setCodfun(resultSet.getInt("codfun"));
                func.setNomfun(resultSet.getString("nomfun"));
                func.setCpffun(resultSet.getString("cpffun"));
                func.setSenha(resultSet.getString("senha"));
                Permissao p = new Permissao(resultSet.getInt("id_permissao"), resultSet.getString("nome_permissao"));
                func.setPermissao(p);
                funcionarios.add(func);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return funcionarios;
    }

    public String setFuncionario(Funcionario func, int perm){

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO funcionario (nomfun, cpffun, senha, id_permissao) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, func.getNomfun());
            preparedStatement.setString(2, func.getCpffun());
            preparedStatement.setString(3, func.getSenha());
            preparedStatement.setInt(4, perm);
            preparedStatement.execute();

        }catch (PSQLException e){
            e.printStackTrace();
            return "cpf";
        }
        catch (SQLException e){
            e.printStackTrace();
            return  "erro";
        }


        return "certo";
    }

    public String updFun (Funcionario func, int perm){

        String teste = "certo";

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = "UPDATE funcionario SET nomfun = ?, cpffun = ?, senha = ?, id_permissao = ? WHERE codfun = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, func.getNomfun());
            preparedStatement.setString(2, func.getCpffun());
            preparedStatement.setString(3, func.getSenha());
            preparedStatement.setInt(4, perm);
            preparedStatement.setInt(5, func.getCodfun());
            preparedStatement.execute();

        }catch (PSQLException e){
            e.printStackTrace();
            teste = "cpf";
        }
        catch (SQLException e){
            e.printStackTrace();
            teste = "erro";
        }
        return teste;
    }

    public void delfun(String cpf){
        try (Connection connection = new ConectaDB().getConexao()) {
            this.sql = " DELETE FROM funcionario where cpffun = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, cpf);
            this.preparedStatement.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}