package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {

    Stage stage = new Stage();

    @FXML
    private Label ExpiringMedicines;

    @FXML
    private Label TotalMedicines;

    @FXML
    private Label TotalSales;

    @FXML
    private Label TotalSuppliers;

    @FXML
    void btnBillingAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(""))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnDashBoardAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(""))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnLogoutAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnMedicinesAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/medicines.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSalesAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(""))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSuppliersAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/suppliers.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
