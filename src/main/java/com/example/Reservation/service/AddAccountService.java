package com.example.Reservation.service;

import com.example.Reservation.entity.AccountEntity;
import com.example.Reservation.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddAccountService {
    @Autowired
    private AccountRepository accountRepository;
    public AccountEntity saveInfo()
    {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUser_Id("blueway8099");
        accountEntity.setUser_Pwd("684231");
        accountEntity.setUser_Name("chris");
        accountEntity.setUser_Email("xxxx@email.com");
        return accountRepository.saveAndFlush(accountEntity);
    }
}
