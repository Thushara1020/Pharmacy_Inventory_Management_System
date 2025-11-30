package controller.sales;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SalesFormController {
    Stage stage =new Stage();

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colCustomer;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colInvoiceId;

    @FXML
    private TableColumn<?, ?> colPaymentType;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableView<?> salesTable;

    @FXML
    private Label txtMonthlySales;

    @FXML
    private Label txtTopSellingMedicine;

    @FXML
    private Label txtTotalTodaySales;

    @FXML
    void btnBillingAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/"))));
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
    void btnDeleteAction(MouseEvent event) {

    }

    @FXML
    void btnEditAction(ActionEvent event) {

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

}
