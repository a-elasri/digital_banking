package com.elasri.digital_bank_backend.dtos;


import com.elasri.digital_bank_backend.enums.AccountStatus;
import lombok.Data;

import java.util.Date;


@Data
public class CurrentBankAccountDTO extends BankAccountDTO {

    private String id;

    private double balance;

    private Date createdAt;

    private CustomerDTO customer;

    private AccountStatus status;

    private double overDraft;

}
