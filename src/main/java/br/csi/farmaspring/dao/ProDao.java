package br.csi.farmaspring.dao;

import br.csi.farmaspring.model.Funcionario;
import br.csi.farmaspring.model.Permissao;
import br.csi.farmaspring.model.Produto;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProDao {
    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Produto getProd(int codpro) {
        Produto prod = null;

        try (Connection connection = new ConectaDB().getConexao()) {
            this.sql = " SELECT * FROM produto where codpro = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, codpro);
            this.resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()){
                prod = new Produto();
                prod.setCodpro(resultSet.getInt("codpro"));
                prod.setNompro(resultSet.getString("nompro"));
                prod.setValor(resultSet.getString("valor"));
            }

        } catch (PSQLException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return prod;
    }

    public String setProd(Produto prod){

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO produto (nompro, valor) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, prod.getNompro());
            preparedStatement.setString(2, prod.getValor());
            preparedStatement.execute();

        }catch (PSQLException e){
            e.printStackTrace();
            return "nome";
        }
        catch (SQLException e){
            e.printStackTrace();
            return  "erro";
        }

        return "certo";
    }

    public ArrayList<Produto> listProd(){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = " SELECT * FROM produto";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()){
                Produto prod = new Produto();
                prod.setCodpro(resultSet.getInt("codpro"));
                prod.setNompro(resultSet.getString("nompro"));
                prod.setValor(resultSet.getString("valor"));
                produtos.add(prod);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return  produtos;
    }

    public String updPro (Produto prod){

        System.out.println(prod.getCodpro());
        String teste = "certo";

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = "UPDATE produto SET nompro = ?, valor = ? WHERE codpro = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, prod.getNompro());
            preparedStatement.setString(2, prod.getValor());
            preparedStatement.setInt(3, prod.getCodpro());
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

    public void delProd(int codpro){
        try (Connection connection = new ConectaDB().getConexao()) {
            this.sql = " DELETE FROM produto where codpro = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, codpro);
            this.preparedStatement.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
