package com.elasri.digital_bank_backend.dtos;

import com.elasri.digital_bank_backend.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountOperationDTO {
    private long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private String description;
}
