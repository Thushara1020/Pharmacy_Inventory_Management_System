package controller.billing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillingFormController {

    private static final Logger LOGGER = Logger.getLogger(BillingFormController.class.getName());
    private static final String RESOURCE_NOT_FOUND = "Resource not found";

    @FXML
    private TableView<?> billingTable;

    @FXML
    private Button btnAddToBill;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<?, ?> colItem;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblDiscount;

    @FXML
    private Label lblFinalTotal;

    @FXML
    private Label lblSubtotal;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtMedicineId;

    @FXML
    private TextField txtMedicineName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

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
        stage.show();

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
        stage.show();

    }

    @FXML
    void btnMedicinesAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        java.net.URL resource = getClass().getResource("/view/medicines.fxml");
        if (resource == null) {
            showLoadError("medicines.fxml", new IOException(RESOURCE_NOT_FOUND));
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
            showLoadError("sales.fxml", new IOException(RESOURCE_NOT_FOUND));
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
            showLoadError("suppliers.fxml", new IOException(RESOURCE_NOT_FOUND));
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
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("View Load Error");
        alert.setHeaderText(null);
        alert.setContentText("Failed to load view: " + fxml + "\n" + e.getMessage());
        alert.showAndWait();
        LOGGER.log(Level.SEVERE, "Failed to load view: " + fxml, e);
    }

}
