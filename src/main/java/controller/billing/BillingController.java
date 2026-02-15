package controller.billing;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.billingDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BillingController implements BillingService {

    @Override
    public void addBillingDetails(String item, int qty, double Price, int total) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String SQL = "INSERT INTO billing (item, qty, Price, total) VALUES(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, item);
            preparedStatement.setObject(2, qty);
            preparedStatement.setObject(3, Price);
            preparedStatement.setObject(4, total);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBillingDetails(String item) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM billing WHERE item = ?");

            pstm.setObject(1, item);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBillingDetails(String item, int qty, double Price, int total) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();

            String SQL = "UPDATE billing SET qty = ?, Price = ?, total = ? WHERE item = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, qty);
            preparedStatement.setObject(2, Price);
            preparedStatement.setObject(3, total);
            preparedStatement.setObject(4, item);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<billingDTO> getAllBillingDetails() {
        ObservableList<billingDTO> billingList = FXCollections.observableArrayList();

        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String SQL = "SELECT * FROM billing";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                billingList.add(new billingDTO(
                        resultSet.getString("item"),
                        resultSet.getInt("qty"),
                        resultSet.getDouble("Price"),
                        resultSet.getInt("total")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return billingList;
    }
} // Final closing brace for the class