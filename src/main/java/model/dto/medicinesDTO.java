package model.dto;

import javafx.beans.property.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor      // default constructor එක generate කරයි
@AllArgsConstructor     // සියලු fields එක්ක constructor එක generate කරයි
public class medicinesDTO {

    private final IntegerProperty medicine_id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty brand = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> expiry_date = new SimpleObjectProperty<>();
    private final IntegerProperty quantity = new SimpleIntegerProperty();
    private final IntegerProperty price = new SimpleIntegerProperty();

    public <T> medicinesDTO(int medicineId, String name, String brand, T expiryDate, int quantity, int price) {

    }

    // JavaFX TableView සඳහා getters/setters අනිවාර්යයෙන්ම ඕනේ
    public int getMedicine_id() { return medicine_id.get(); }
    public void setMedicine_id(int value) { medicine_id.set(value); }
    public IntegerProperty medicine_idProperty() { return medicine_id; }

    public String getName() { return name.get(); }
    public void setName(String value) { name.set(value); }
    public StringProperty nameProperty() { return name; }

    public String getBrand() { return brand.get(); }
    public void setBrand(String value) { brand.set(value); }
    public StringProperty brandProperty() { return brand; }

    public LocalDate getExpiry_date() { return expiry_date.get(); }
    public void setExpiry_date(LocalDate value) { expiry_date.set(value); }
    public ObjectProperty<LocalDate> expiry_dateProperty() { return expiry_date; }

    public int getQuantity() { return quantity.get(); }
    public void setQuantity(int value) { quantity.set(value); }
    public IntegerProperty quantityProperty() { return quantity; }

    public int getPrice() { return price.get(); }
    public void setPrice(int value) { price.set(value); }
    public IntegerProperty priceProperty() { return price; }
}