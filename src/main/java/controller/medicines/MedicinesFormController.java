package controller.medicines;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.medicinesDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MedicinesFormController implements Initializable {
    MedicinesService medicinesService = new MedicinesController();

    ObservableList<medicinesDTO> medicinesDTOS = FXCollections.observableArrayList();

    Stage stage = new Stage();

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
    private TableView<medicinesDTO> medicineTable;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("medicine_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("neme"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        loadAllMedicines();

        medicineTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValues) -> {
            if (newValues!= null) {
                setSelectedValue(newValues);
            }
        });

    }

    private void setSelectedValue(medicinesDTO selectedValue) {
        if(selectedValue == null){
            clearFields();
            return;
        }
        txtId.setText(String.valueOf(selectedValue.getMedicine_id()));
        txtName.setText(selectedValue.getName());
        txtBrand.setText(selectedValue.getBrand());
        txtExpiry.setText(String.valueOf(selectedValue.getExpiry_date()));
        txtQty.setText(String.valueOf(selectedValue.getQuantity()));
        txtPrice.setText(String.valueOf(selectedValue.getPrice()));

    }

    private void clearFields() {
        txtId.clear();
        txtName.clear();
        txtBrand.clear();
        txtExpiry.clear();
        txtQty.clear();
        txtPrice.clear();
    }


    private void loadAllMedicines() {
        medicinesDTOS.clear();
        medicineTable.setItems(medicinesService.getAllItemDetails());
    }
}
