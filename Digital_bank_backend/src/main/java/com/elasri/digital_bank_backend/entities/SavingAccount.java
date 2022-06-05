package com.elasri.digital_bank_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SAVING")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavingAccount extends BankAccount {

    private double interestRate;

}
