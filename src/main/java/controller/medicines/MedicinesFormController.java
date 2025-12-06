package controller.medicines;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MedicinesFormController {

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
    void btnApdateAction(ActionEvent event) {

    }

    @FXML
    void btnBillingAction(ActionEvent event) {

    }

    @FXML
    void btnDashBoardAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

    }

    @FXML
    void btnLogoutAction(ActionEvent event) {

    }

    @FXML
    void btnSalesAction(ActionEvent event) {

    }

    @FXML
    void btnSuppliersAction(ActionEvent event) {

    }

}
