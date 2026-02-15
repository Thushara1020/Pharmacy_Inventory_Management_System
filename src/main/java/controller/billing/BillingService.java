package controller.billing;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import model.dto.billingDTO;

public interface BillingService{

    void addBillingDetails(String itme, int qty, double Price, int total);

    void deleteBillingDetails(String item);

    void updateBillingDetails(String item, int qty, double Price, int total);

    ObservableList<billingDTO> getAllBillingDetails();
}
