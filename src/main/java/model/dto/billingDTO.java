package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class billingDTO {

    private String item;

    private int qty;

    private double Price;

    private int total;
}
