package controller.medicines;

import javafx.collections.ObservableList;
import model.dto.medicinesDTO;

import java.time.LocalDate;

public interface MedicinesService {
    void addMedicinesDeteils(int medicine_id, String name, String brand, int expiry_date, int quantity, int price);

    void addMedicinesDeteils(int medicine_id, String name, String brand, LocalDate expiry_date, int quantity, int price);

    void deleteMedicinesDetails(String medicines_id);

    ObservableList<medicinesDTO> getAllItemDetails();

    void updateMedicinesDetails(int medicineId, String name, String brand, LocalDate expiryDate, int quantity, int price);
}
