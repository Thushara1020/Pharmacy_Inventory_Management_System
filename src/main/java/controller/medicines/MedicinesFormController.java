package controller.medicines;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MedicinesFormController {
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(MedicinesFormController.class.getName());
    private static final String RESOURCE_NOT_FOUND = "Resource not found";

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colBrand;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableView<?> medicineTable;

    @FXML
    private TableColumn<?, ?> olExpiryDate;

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtExpiry;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    @FXML
    void btnAddAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

    }

    @FXML
    void btnBillingAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        java.net.URL resource = getClass().getResource("/view/billing.fxml");
        if (resource == null) {
            showLoadError("billing.fxml", new IOException(RESOURCE_NOT_FOUND));
            return;
        }
        try {
            stage.setScene(new Scene(FXMLLoader.load(resource)));
        } catch (IOException e) {
            showLoadError("billing.fxml", e);
        }
        stage.setTitle("Billing Form");
        stage.show();

    }

    @FXML
    void btnDashBoardAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        java.net.URL resource = getClass().getResource("/view/dashboard.fxml");
        if (resource == null) {
            showLoadError("dashboard.fxml", new IOException(RESOURCE_NOT_FOUND));
            return;
        }
        try {
            stage.setScene(new Scene(FXMLLoader.load(resource)));
        } catch (IOException e) {
            showLoadError("dashboard.fxml", e);
        }
        stage.setTitle("Dashboard Form");
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
            showLoadError("login.fxml", new IOException(RESOURCE_NOT_FOUND));
            return;
        }
        try {
            stage.setScene(new Scene(FXMLLoader.load(resource)));
        } catch (IOException e) {
            showLoadError("login.fxml", e);
        }
        stage.setTitle("Login Form");
        stage.show();

    }

    @FXML
    void btnSalesAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        java.net.URL resource = getClass().getResource("/view/sales.fxml");
        if (resource == null) {
            showLoadError("sales.fxml", new IOException(RESOURCE_NOT_FOUND));
            return;
        }
        try {
            stage.setScene(new Scene(FXMLLoader.load(resource)));
        } catch (IOException e) {
            showLoadError("sales.fxml", e);
        }
        stage.setTitle("Sales Form");
        stage.show();

    }

    @FXML
    void btnSuppliersAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        java.net.URL resource = getClass().getResource("/view/suppliers.fxml");
        if (resource == null) {
            showLoadError("suppliers.fxml", new IOException(RESOURCE_NOT_FOUND));
            return;
        }
        try {
            stage.setScene(new Scene(FXMLLoader.load(resource)));
        } catch (IOException e) {
            showLoadError("suppliers.fxml", e);
        }
        stage.setTitle("Suppliers Form");
        stage.show();

    }

    private void showLoadError(String fxml, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("View Load Error");
        alert.setHeaderText(null);
        alert.setContentText("Failed to load view: " + fxml + "\n" + e.getMessage());
        alert.showAndWait();
        LOGGER.log(java.util.logging.Level.SEVERE, "Failed to load view: " + fxml, e);
    }

}
