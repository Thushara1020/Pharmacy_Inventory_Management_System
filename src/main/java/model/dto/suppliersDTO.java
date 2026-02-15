package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class suppliersDTO {
    private int id;
    private String name;
    private String contactNumber;
    private String email;
    private String address;
}
