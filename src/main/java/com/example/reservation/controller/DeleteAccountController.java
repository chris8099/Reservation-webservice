package com.example.reservation.controller;



import com.example.reservation.entity.AccountEntity;
import com.example.reservation.repository.AccountRepository;
import com.example.reservation.repository.DeleteAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/delete_user",produces = MediaType.APPLICATION_JSON_VALUE)
public class DeleteAccountController {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    DeleteAccountRepository deleteAccountRepository;
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteUser(@PathVariable("id") Long id)
    {
        List<AccountEntity> accountEntities = accountRepository.findAll();
        boolean isRemoved = accountEntities.removeIf(p -> p.getId()==id);
        deleteAccountRepository.deleteById(id);
        return isRemoved
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }


}