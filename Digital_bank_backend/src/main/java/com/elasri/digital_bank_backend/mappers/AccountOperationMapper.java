package com.elasri.digital_bank_backend.mappers;

import com.elasri.digital_bank_backend.dtos.AccountOperationDTO;
import com.elasri.digital_bank_backend.entities.AccountOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountOperationMapper {

    public AccountOperationDTO fromAccountOperation (AccountOperation accountOperation){
        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();
        BeanUtils.copyProperties( accountOperation, accountOperationDTO);
        return  accountOperationDTO;
    }


}
