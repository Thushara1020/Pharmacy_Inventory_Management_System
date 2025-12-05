package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class medicinesDTO {
    private int medicine_id;

    private  String name;

    private  String brand;

    private  int expiry_date;

    private  int quantity;

    private int price;

}
