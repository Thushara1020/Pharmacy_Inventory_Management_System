package controller.medicines;

import db.DbConnection;
import javafx.collections.ObservableList;
import model.dto.medicinesDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicinesController implements MedicinesService {

    @Override
    public void addMedicinesDeteils(int medicine_id, String name, String brand, int expiry_date, int quantity, int price){

        try {
            Connection connection = DbConnection.getInstance().getConnection();

            String SQL = "INSERT INTO medicines VALUES(?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1,medicine_id);
            preparedStatement.setObject(2,name);
            preparedStatement.setObject(3,brand);
            preparedStatement.setObject(4,expiry_date);
            preparedStatement.setObject(5,quantity);
            preparedStatement.setObject(6,price);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @Override
    public void deleteMedicinesDetails(String medicines_id) {

        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM medicines");

            preparedStatement.setObject(1,medicines_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateMedicinesDetails(int medicine_id, String name, String brand, int expiry_date, int quantity, int price){

        try {
            Connection connection = DbConnection.getInstance().getConnection();

            String SQL = "UPDATE medicines SET medicine_id = ?, name = ?, brand = ?, expiry_date = ?, quantity = ?, price = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1,medicine_id);
            preparedStatement.setObject(2,name);
            preparedStatement.setObject(3,brand);
            preparedStatement.setObject(4,expiry_date);
            preparedStatement.setObject(5,quantity);
            preparedStatement.setObject(6,price);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public ObservableList<medicinesDTO> getAllItemDetails() {
        ObservableList<medicinesDTO> itemDetails = javafx.collections.FXCollections.observableArrayList();

        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String SQL = "SELECT * FROM item";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                itemDetails.add(new medicinesDTO(
                        resultSet.getInt("medicine_id"),
                        resultSet.getString("name"),
                        resultSet.getString("brand"),
                        resultSet.getInt("expiry_date"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("price")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemDetails;
    }
}
