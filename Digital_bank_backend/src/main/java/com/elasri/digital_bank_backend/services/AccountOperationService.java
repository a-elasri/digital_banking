package com.elasri.digital_bank_backend.services;


import com.elasri.digital_bank_backend.dtos.AccountHistoryDTO;
import com.elasri.digital_bank_backend.dtos.AccountOperationDTO;
import com.elasri.digital_bank_backend.exceptions.BankAccountNotFoundExcetion;
import com.elasri.digital_bank_backend.exceptions.OperationNotFoundException;

import java.util.List;

public interface AccountOperationService {

    public List<AccountOperationDTO> getAccountOperationsHistory(String accountId);

    public AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundExcetion;


    AccountOperationDTO getOperation(long operationId) throws OperationNotFoundException;
}
