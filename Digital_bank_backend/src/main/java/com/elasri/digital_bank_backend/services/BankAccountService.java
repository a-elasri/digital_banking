package com.elasri.digital_bank_backend.services;

import com.elasri.digital_bank_backend.dtos.BankAccountDTO;
import com.elasri.digital_bank_backend.dtos.CurrentBankAccountDTO;
import com.elasri.digital_bank_backend.dtos.SavingBankAccountDTO;
import com.elasri.digital_bank_backend.entities.CurrentAccount;
import com.elasri.digital_bank_backend.entities.SavingAccount;
import com.elasri.digital_bank_backend.exceptions.BalanceNotSufficientException;
import com.elasri.digital_bank_backend.exceptions.BankAccountNotFoundExcetion;
import com.elasri.digital_bank_backend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {


    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, String customerId) throws CustomerNotFoundException;

    BankAccountDTO updateCurrentBankAccount(CurrentAccount currentAccount) throws BankAccountNotFoundExcetion;

    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, String customerId) throws CustomerNotFoundException;


    BankAccountDTO updateSavingBankAccount(SavingAccount savingAccount) throws BankAccountNotFoundExcetion;

    BankAccountDTO getBankAccount(String bankAccountId) throws BankAccountNotFoundExcetion;

    void debit( String accountId, double amount, String description) throws BankAccountNotFoundExcetion, BalanceNotSufficientException;

    void credit( String accountId, double amount, String description) throws BankAccountNotFoundExcetion;

    void transfer( String accountSourceId, String accountDestinationId, double amount, String description) throws BankAccountNotFoundExcetion, BalanceNotSufficientException;

    List<BankAccountDTO> listBankAccountDTO();

    void deleteAccount(String accountId);
}
