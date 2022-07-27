package br.csi.farmaspring.dao;

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

    public String setProd(Produto prod){

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO produto (nompro, valor) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, prod.getNompro());
            preparedStatement.setInt(2, prod.getValor());
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
                prod.setValor(resultSet.getInt("valor"));
                produtos.add(prod);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return  produtos;
    }

    public void delProd(String codpro){
        try (Connection connection = new ConectaDB().getConexao()) {
            this.sql = " DELETE FROM produto where codpro = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, codpro);
            this.preparedStatement.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
