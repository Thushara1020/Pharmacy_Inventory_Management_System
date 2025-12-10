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
    Stage stage = new Stage();

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
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(""))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void btnDashBoardAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

    }

    @FXML
    void btnLogoutAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void btnMedicinesAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/medicines.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void btnSalesAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/sales.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void btnSuppliersAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/suppliers.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

    }

}
