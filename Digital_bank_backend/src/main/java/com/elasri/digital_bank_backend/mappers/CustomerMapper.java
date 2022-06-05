package com.elasri.digital_bank_backend.mappers;

import com.elasri.digital_bank_backend.dtos.CustomerDTO;
import com.elasri.digital_bank_backend.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties( customer, customerDTO);
        return customerDTO;
    }

    public Customer fromCustomerDto( CustomerDTO customerDto){
        Customer customer = new Customer();
        BeanUtils.copyProperties( customerDto, customer);
        return customer;
    }

}
