package controller.suppliers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SuppliersFormController {
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(SuppliersFormController.class.getName());
    private static final String RESOURCE_NOT_FOUND = "Resource not found";

    @FXML
    private Button btnAddSupplier;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<?> supplierTable;

    @FXML
    private TextField txtSupAddress;

    @FXML
    private TextField txtSupContact;

    @FXML
    private TextField txtSupEmail;

    @FXML
    private TextField txtSupId;

    @FXML
    private TextField txtSupName;

    @FXML
    void btnAddAction(ActionEvent event) {

    }

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
    void btnDashBoardAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        java.net.URL resource = getClass().getResource("/view/dashboard.fxml");
        if (resource == null) {
            showLoadError("dashboard.fxml", new IOException("Resource not found"));
            return;
        }
        try {
            stage.setScene(new Scene(FXMLLoader.load(resource)));
        } catch (IOException e) {
            showLoadError("dashboard.fxml", e);
        }
        stage.show();

    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

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

    @FXML
    void btnUpdateAction(ActionEvent event) {

    }

    private void showLoadError(String fxml, Exception e) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("View Load Error");
        alert.setHeaderText(null);
        alert.setContentText("Failed to load view: " + fxml + "\n" + e.getMessage());
        alert.showAndWait();
        LOGGER.log(java.util.logging.Level.SEVERE, "Failed to load view: " + fxml, e);
    }

}
