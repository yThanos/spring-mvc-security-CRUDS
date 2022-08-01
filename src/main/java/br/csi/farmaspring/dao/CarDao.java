package br.csi.farmaspring.dao;

import br.csi.farmaspring.model.Carinho;
import br.csi.farmaspring.model.Venda;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarDao {
    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ArrayList<Carinho> listCar(){
        ArrayList<Carinho> cars = new ArrayList<Carinho>();

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = " SELECT * FROM Carinho";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()){
                Carinho vend = new Carinho();
                vend.setCodcar(resultSet.getInt("codcar"));
                int codcli = (resultSet.getInt("codclicar"));
                int codpro = (resultSet.getInt("codprocar"));
                vend.setClicar(new CliDao().getCli(codcli));
                vend.setProcar(new ProDao().getProd(codpro));
                vend.setQnt(resultSet.getInt("qntcar"));
                cars.add(vend);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return cars;
    }

    public String setVen(Carinho vend){

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO carinho (codclicar, codprocar, qntcar) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, vend.getClicar().getCodcli());
            preparedStatement.setInt(2, vend.getProcar().getCodpro());
            preparedStatement.setInt(3, vend.getQnt());
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

    public void delcar(int codcar){
        try (Connection connection = new ConectaDB().getConexao()) {
            this.sql = " DELETE FROM carinho where codcar = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, codcar);
            this.preparedStatement.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void fim(){

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = " SELECT * FROM carinho";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()){
                Venda vend = new Venda();
                int codcli = (resultSet.getInt("codclicar"));
                int codpro = (resultSet.getInt("codprocar"));
                vend.setCliven(new CliDao().getCli(codcli));
                vend.setProven(new ProDao().getProd(codpro));
                vend.setQtdven(resultSet.getInt("qntcar"));
                new VenDao().setVen(vend);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void limpa(){
        try (Connection connection = new ConectaDB().getConexao()) {
            this.sql = " DELETE FROM carinho";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}