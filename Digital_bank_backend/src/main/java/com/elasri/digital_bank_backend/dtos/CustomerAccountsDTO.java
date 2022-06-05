package com.elasri.digital_bank_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccountsDTO {

    private String customerId;
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private List<BankAccountDTO> accounts;

}
