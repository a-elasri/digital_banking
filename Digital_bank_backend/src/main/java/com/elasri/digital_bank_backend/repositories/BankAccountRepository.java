package com.elasri.digital_bank_backend.repositories;


import com.elasri.digital_bank_backend.entities.BankAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    @Query("Select B FROM BankAccount B WHERE B.customer.id=:customerId ORDER BY B.createdAt")
    public Page<BankAccount> getCustomerAccounts(@Param("customerId") String customerId, Pageable pageable);

}
