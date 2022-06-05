package com.elasri.digital_bank_backend.services;

import com.elasri.digital_bank_backend.dtos.CustomerAccountsDTO;
import com.elasri.digital_bank_backend.dtos.CustomerDTO;
import com.elasri.digital_bank_backend.dtos.CustomerPageableDTO;
import com.elasri.digital_bank_backend.entities.BankAccount;
import com.elasri.digital_bank_backend.entities.CurrentAccount;
import com.elasri.digital_bank_backend.entities.Customer;
import com.elasri.digital_bank_backend.entities.SavingAccount;
import com.elasri.digital_bank_backend.exceptions.CustomerNotFoundException;
import com.elasri.digital_bank_backend.mappers.BankAccountMapper;
import com.elasri.digital_bank_backend.mappers.CustomerMapper;
import com.elasri.digital_bank_backend.repositories.BankAccountRepository;
import com.elasri.digital_bank_backend.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Transactional
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
    private BankAccountRepository accountRepository;
    private BankAccountMapper bankAccountMapper;


    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("⌛ saving customer... ");
        customer.setId(UUID.randomUUID().toString());
        Customer savedCustomer = customerRepository.save(customer);
        log.info("✔ customer saved ");
        return savedCustomer;
    }


    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        log.info("⌛ saving customer... ");
        customerDTO.setId(UUID.randomUUID().toString());
        Customer customer = customerMapper.fromCustomerDto( customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("✔ customer saved ");
        return customerMapper.fromCustomer(savedCustomer);
    }

    @Override
    public List<CustomerDTO> listCustomers() {
        log.info("✔ Got the list of customers !");
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = customers.stream().map(customer -> customerMapper.fromCustomer(customer)).collect(Collectors.toList());
        return customerDTOS;
    }

    @Override
    public CustomerDTO getCustomer(String customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer with id '"+customerId+"' is Not found !"));
        return customerMapper.fromCustomer( customer);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) throws CustomerNotFoundException {
        log.info("⌛ updating customer... ");
        customerRepository.findById( customerDTO.getId()).orElseThrow(()-> new CustomerNotFoundException("Customer Not Found !"));
        Customer customer = customerMapper.fromCustomerDto( customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("✔ customer updated ");
        return customerMapper.fromCustomer(savedCustomer);
    }

    @Override
    public void deleteCustomer(String customerId) {
        log.info("⌛ deleting customer... ");
        customerRepository.deleteById(customerId);
        log.info("✔ customer deleted ");
    }

    @Override
    public List<CustomerDTO> searchCustomer( String searchKeyword){
        List<Customer> customerList = customerRepository.searchCustomerByName("%"+searchKeyword+"%" );

        return customerList.stream().map( customer -> customerMapper.fromCustomer( customer))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerPageableDTO searchCustomerPaginated( int page, int size, String searchKeyword){
        Page<Customer> customers = customerRepository.searchCustomerByNamePaginated("%"+searchKeyword+"%", PageRequest.of(page, size) );

        CustomerPageableDTO dto = new CustomerPageableDTO();
        dto.setCurrentPage( page );
        dto.setPageSize(size);
        dto.setTotalPages( customers.getTotalPages() );
        dto.setCustomers(
                customers.getContent().stream().map(customer -> {
                    return customerMapper.fromCustomer( customer );
                }).collect(Collectors.toList())
        );
        return dto;
    }

    @Override
    public CustomerAccountsDTO getCustomerAccounts(String customerId, int page, int size) throws CustomerNotFoundException {
        this.getCustomer(customerId); // throws exception if not found
        Page<BankAccount> customerAccounts = accountRepository.getCustomerAccounts(customerId, PageRequest.of(page, size));

        CustomerAccountsDTO dto = new CustomerAccountsDTO();
        dto.setCustomerId( customerId );
        dto.setCurrentPage( page);
        dto.setTotalPages( customerAccounts.getTotalPages() );
        dto.setPageSize(size);
        dto.setAccounts(
                customerAccounts.getContent().stream().map( bankAccount -> {
                    if (bankAccount instanceof SavingAccount)
                        return bankAccountMapper.fromSavingAccount((SavingAccount) bankAccount);
                    return bankAccountMapper.fromCurrentAccount((CurrentAccount) bankAccount);
                }).collect(Collectors.toList())
        );
        return dto;
    }


    @Override
    public CustomerPageableDTO paginateCustomers(int page, int size) {
        Page<Customer> customers = customerRepository.findAll( PageRequest.of(page,size));

        CustomerPageableDTO dto = new CustomerPageableDTO();
        dto.setCurrentPage( page );
        dto.setPageSize(size);
        dto.setTotalPages( customers.getTotalPages() );
        dto.setCustomers(
                customers.getContent().stream().map(customer -> {
                    return customerMapper.fromCustomer( customer );
                }).collect(Collectors.toList())
        );
        return dto;
    }


}
