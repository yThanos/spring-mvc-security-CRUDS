package br.csi.farmaspring.dao;

import br.csi.farmaspring.model.Cliente;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CliDao {
    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Cliente getCli(String cpf) {
        Cliente cli = new Cliente();
        try (Connection connection = new ConectaDB().getConexao()) {
            this.sql = " SELECT * FROM cliente where cpfcli = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, cpf);
            this.resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()){
                cli.setCodcli(resultSet.getInt("codcli"));
                cli.setNomcli(resultSet.getString("nomcli"));
                cli.setCpfcli(resultSet.getString("cpfcli"));
            }

        } catch (PSQLException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return cli;
    }

    public ArrayList<Cliente> listCli(){
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = " SELECT * FROM cliente";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()){
                Cliente cli = new Cliente();
                cli.setCodcli(resultSet.getInt("codcli"));
                cli.setNomcli(resultSet.getString("nomcli"));
                cli.setCpfcli(resultSet.getString("cpfcli"));
                clientes.add(cli);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return clientes;
    }

    public String setCliente(Cliente cli){

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO cliente (nomcli, cpfcli) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cli.getNomcli());
            preparedStatement.setString(2, cli.getCpfcli());
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
            this.sql = "UPDATE clietne SET nomcli = ?, cpfcli = ? WHERE codcli = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cli.getNomcli());
            preparedStatement.setString(2, cli.getCpfcli());
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

    public void delCli(String cpf){
        try (Connection connection = new ConectaDB().getConexao()) {
            this.sql = " DELETE FROM cliente where cpffun = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, cpf);
            this.preparedStatement.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}