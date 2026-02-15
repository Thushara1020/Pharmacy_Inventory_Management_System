package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class medicinesDTO {

    private int id;
    private String name;
    private String brand;
    private LocalDate expiryDate;
    private int quantity;
    private double price;
}