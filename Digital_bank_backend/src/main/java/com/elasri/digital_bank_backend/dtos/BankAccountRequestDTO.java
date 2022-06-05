package com.elasri.digital_bank_backend.dtos;


import com.elasri.digital_bank_backend.enums.AccountStatus;
import lombok.Data;

import java.util.Date;


@Data
public class BankAccountRequestDTO  {
    private String id;

    private double balance;

    private Date createdAt;

    private CustomerDTO customer;
    private double overDraft;
    private String type;
    private double interestRate;
    private AccountStatus status;
}
