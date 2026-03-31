package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DashBoardFormController {

    private static final Logger LOGGER = Logger.getLogger(DashBoardFormController.class.getName());

    // Do not create a new Stage for each navigation. Use the current window from the event.

    @FXML
    private Label expiringMedicines;

    @FXML
    private Label totalMedicines;

    @FXML
    private Label totalSales;

    @FXML
    private Label totalSuppliers;

    @FXML
    void btnBillingAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        java.net.URL resource = getClass().getResource("/view/billing.fxml");
        if (resource == null) {
            showLoadError("billing.fxml", new IOException("Resource not found"));
            return;
        }
        try {
            stage.setScene(new Scene(FXMLLoader.load(resource)));
        } catch (IOException e) {
            showLoadError("billing.fxml", e);
        }
        stage.show();

    }


    @FXML
    void btnLogoutAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        java.net.URL resource = getClass().getResource("/view/login.fxml");
        if (resource == null) {
            showLoadError("login.fxml", new IOException("Resource not found"));
            return;
        }
        try {
            stage.setScene(new Scene(FXMLLoader.load(resource)));
        } catch (IOException e) {
            showLoadError("login.fxml", e);
        }
        stage.show();

    }

    @FXML
    void btnMedicinesAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        java.net.URL resource = getClass().getResource("/view/medicines.fxml");
        if (resource == null) {
            showLoadError("medicines.fxml", new IOException("Resource not found"));
            return;
        }
        try {
            stage.setScene(new Scene(FXMLLoader.load(resource)));
        } catch (IOException e) {
            showLoadError("medicines.fxml", e);
        }
        stage.show();
    }

    @FXML
    void btnSalesAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        java.net.URL resource = getClass().getResource("/view/sales.fxml");
        if (resource == null) {
            showLoadError("sales.fxml", new IOException("Resource not found"));
            return;
        }
        try {
            stage.setScene(new Scene(FXMLLoader.load(resource)));
        } catch (IOException e) {
            showLoadError("sales.fxml", e);
        }
        stage.show();
    }

    @FXML
    void btnSuppliersAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        java.net.URL resource = getClass().getResource("/view/suppliers.fxml");
        if (resource == null) {
            showLoadError("suppliers.fxml", new IOException("Resource not found"));
            return;
        }
        try {
            stage.setScene(new Scene(FXMLLoader.load(resource)));
        } catch (IOException e) {
            showLoadError("suppliers.fxml", e);
        }
        stage.show();
    }

    private void showLoadError(String fxml, Exception e) {
        // Show a user friendly alert and log the error to console.
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("View Load Error");
        alert.setHeaderText(null);
        alert.setContentText("Failed to load view: " + fxml + "\n" + e.getMessage());
        alert.showAndWait();
        LOGGER.log(Level.SEVERE, "Failed to load view: " + fxml, e);
    }

}
