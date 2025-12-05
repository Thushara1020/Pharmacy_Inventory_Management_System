package controller.medicines;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.medicinesDTO;

import java.sql.*;
import java.time.LocalDate;

public abstract class MedicinesController implements MedicinesService {

    @Override
    public void addMedicinesDeteils(int medicine_id, String name, String brand, LocalDate expiry_date, int quantity, int price) {
        String SQL = "INSERT INTO medicines (medicine_id, name, brand, expiry_date, quantity, price) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(SQL)) {

            pstm.setInt(1, medicine_id);
            pstm.setString(2, name);
            pstm.setString(3, brand);
            pstm.setObject(4, expiry_date);   // LocalDate directly support karanwa MySQL DATE type ekata
            pstm.setInt(5, quantity);
            pstm.setInt(6, price);

            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error adding medicine: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteMedicinesDetails(String medicines_id) {
        String SQL = "DELETE FROM medicines WHERE medicine_id = ?"; // WHERE clause eka illa!

        try (Connection conn = DbConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(SQL)) {

            pstm.setString(1, medicines_id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting medicine: " + e.getMessage(), e);
        }
    }

    public void updateMedicinesDetails(int medicine_id, String name, String brand, LocalDate expiry_date, int quantity, int price) {
        String SQL = "UPDATE medicines SET name = ?, brand = ?, expiry_date = ?, quantity = ?, price = ? WHERE medicine_id = ?";

        try (Connection conn = DbConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(SQL)) {

            pstm.setString(1, name);
            pstm.setString(2, brand);
            pstm.setObject(3, expiry_date);
            pstm.setInt(4, quantity);
            pstm.setInt(5, price);
            pstm.setInt(6, medicine_id);

            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating medicine: " + e.getMessage(), e);
        }
    }

    @Override
    public ObservableList<medicinesDTO> getAllItemDetails() {
        ObservableList<medicinesDTO> list = FXCollections.observableArrayList();
        String SQL = "SELECT * FROM medicines";

        try (Connection conn = DbConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(SQL);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                medicinesDTO dto = new medicinesDTO(
                        rs.getInt("medicine_id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getObject("expiry_date", LocalDate.class),
                        rs.getInt("quantity"),
                        rs.getInt("price")
                );
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading medicines: " + e.getMessage(), e);
        }
        return list;
    }
}