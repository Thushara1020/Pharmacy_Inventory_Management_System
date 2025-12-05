package controller.medicines;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.medicinesDTO;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MedicinesFormController implements Initializable {

    private final MedicinesService medicinesService = new MedicinesController() {
        @Override
        public void addMedicinesDeteils(int medicine_id, String name, String brand, int expiry_date, int quantity, int price) {

        }
    };

    @FXML private TextField txtId;
    @FXML private TextField txtName;
    @FXML private TextField txtBrand;
    @FXML private TextField txtExpiry;
    @FXML private TextField txtQty;
    @FXML private TextField txtPrice;

    @FXML private TableView<medicinesDTO> medicineTable;

    @FXML private TableColumn<medicinesDTO, Integer> colId;
    @FXML private TableColumn<medicinesDTO, String> colName;
    @FXML private TableColumn<medicinesDTO, String> colBrand;
    @FXML private TableColumn<medicinesDTO, LocalDate> colExpiryDate;
    @FXML private TableColumn<medicinesDTO, Integer> colQuantity;
    @FXML private TableColumn<medicinesDTO, Integer> colPrice;

    @FXML private Button btnAdd;
    @FXML private Button btnUpdate;
    @FXML private Button btnDelete;

    private Stage stage = new Stage();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Table columns mapping
        colId.setCellValueFactory(new PropertyValueFactory<>("medicine_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colExpiryDate.setCellValueFactory(new PropertyValueFactory<>("expiry_date"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        loadAllMedicines();

        // Table row selection
        medicineTable.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, newValue) -> {
                    if (newValue != null) {
                        populateFields(newValue);
                    }
                });
    }

    private void loadAllMedicines() {
        ObservableList<medicinesDTO> data = medicinesService.getAllItemDetails();
        medicineTable.setItems(data);
    }

    @FXML
    void btnAddAction(ActionEvent event) {
        try {
            medicinesDTO dto = getDTOFromFields();
            medicinesService.addMedicinesDeteils(
                    dto.getMedicine_id(),
                    dto.getName(),
                    dto.getBrand(),
                    dto.getExpiry_date(),
                    dto.getQuantity(),
                    dto.getPrice()
            );
            showAlert(Alert.AlertType.INFORMATION, "Success", "Medicine added successfully!");
            loadAllMedicines();
            clearFields();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        try {
            medicinesDTO dto = getDTOFromFields();
            medicinesService.updateMedicinesDetails(
                    dto.getMedicine_id(),
                    dto.getName(),
                    dto.getBrand(),
                    dto.getExpiry_date(),
                    dto.getQuantity(),
                    dto.getPrice()
            );
            showAlert(Alert.AlertType.INFORMATION, "Success", "Medicine updated!");
            loadAllMedicines();
            clearFields();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {
        medicinesDTO selected = medicineTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "Warning", "Please select a medicine to delete!");
            return;
        }

        medicinesService.deleteMedicinesDetails(String.valueOf(selected.getMedicine_id()));
        showAlert(Alert.AlertType.INFORMATION, "Deleted", "Medicine deleted!");
        loadAllMedicines();
        clearFields();
    }

    private medicinesDTO getDTOFromFields() {
        int id = Integer.parseInt(txtId.getText().trim());
        String name = txtName.getText().trim();
        String brand = txtBrand.getText().trim();
        LocalDate expiry = LocalDate.parse(txtExpiry.getText().trim()); // yyyy-MM-dd
        int qty = Integer.parseInt(txtQty.getText().trim());
        int price = Integer.parseInt(txtPrice.getText().trim());

        return new medicinesDTO(id, name, brand, expiry, qty, price);
    }

    private void populateFields(medicinesDTO dto) {
        txtId.setText(String.valueOf(dto.getMedicine_id()));
        txtName.setText(dto.getName());
        txtBrand.setText(dto.getBrand());
        txtExpiry.setText(dto.getExpiry_date().toString());
        txtQty.setText(String.valueOf(dto.getQuantity()));
        txtPrice.setText(String.valueOf(dto.getPrice()));
    }

    private void clearFields() {
        txtId.clear();
        txtName.clear();
        txtBrand.clear();
        txtExpiry.clear();
        txtQty.clear();
        txtPrice.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Navigation methods (Logout, Suppliers, etc.) remain the same
    @FXML void btnLogoutAction(ActionEvent event) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login.fxml"))));
        stage.show();
    }

    @FXML void btnSuppliersAction(ActionEvent event) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/suppliers.fxml"))));
        stage.show();
    }

    @FXML void btnMedicinesAction(ActionEvent event) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/medicines.fxml"))));
        stage.show();
    }
}