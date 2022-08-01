package br.csi.farmaspring.dao;

import br.csi.farmaspring.model.Carinho;
import br.csi.farmaspring.model.Cliente;
import br.csi.farmaspring.model.Venda;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VenDao {
    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ArrayList<Venda> listVen(){
        ArrayList<Venda> vendas = new ArrayList<Venda>();

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = " SELECT * FROM venda";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()){
                Venda vend = new Venda();
                vend.setCodven(resultSet.getInt("codven"));
                int codcli = (resultSet.getInt("codcliven"));
                int codpro = (resultSet.getInt("codproven"));
                vend.setCliven(new CliDao().getCli(codcli));
                vend.setProven(new ProDao().getProd(codpro));
                vend.setQtdven(resultSet.getInt("qntven"));
                vendas.add(vend);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return vendas;
    }

    public String setVen(Venda vend){

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO venda (codcliven, codproven, qntven) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, vend.getCliven().getCodcli());
            preparedStatement.setInt(2, vend.getProven().getCodpro());
            preparedStatement.setInt(3, vend.getQtdven());
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

    public void delven(int codven){
        try (Connection connection = new ConectaDB().getConexao()) {
            this.sql = " DELETE FROM venda where codven = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, codven);
            this.preparedStatement.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}