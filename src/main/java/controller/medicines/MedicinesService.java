package controller.medicines;

import javafx.collections.ObservableList;
import model.dto.medicinesDTO;

public interface MedicinesService {
    void addMedicinesDeteils(int medicine_id, String name, String brand, int expiry_date, int quantity, int price);

    void deleteMedicinesDetails(String medicines_id);

    ObservableList<medicinesDTO> getAllItemDetails();
}
