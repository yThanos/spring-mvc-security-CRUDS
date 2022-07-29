package br.csi.farmaspring.dao;

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
                int codcli = (resultSet.getInt("codcli"));
                int codpro = (resultSet.getInt("codpro"));
                vend.setCliven(new CliDao().getCli(codcli));
                vend.setProven(new ProDao().getProd(codpro));
                vend.setQtdven(resultSet.getInt("qtdven"));
                vendas.add(vend);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return vendas;
    }

    public String setVen(Venda vend){

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO venda (codcli, codpro) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, vend.getCliven().getCodcli());
            preparedStatement.setInt(2, vend.getProven().getCodpro());
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

    public String updCli (Cliente cli){

        String teste = "certo";

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = "UPDATE cliente SET nomcli = ?, cpfcli = ? WHERE codcli = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cli.getNomcli());
            preparedStatement.setString(2, cli.getCpfcli());
            preparedStatement.setInt(3, cli.getCodcli());
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

    public void delCli(int codcli){
        try (Connection connection = new ConectaDB().getConexao()) {
            this.sql = " DELETE FROM cliente where codcli = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, codcli);
            this.preparedStatement.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
