package com.example.reservation.controller;

import com.example.reservation.entity.AccountEntity;
import com.example.reservation.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/addacount", produces = MediaType.APPLICATION_JSON_VALUE)

public class AddAccountController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping
    public ResponseEntity<AccountEntity> createAccount(@RequestBody AccountEntity request) {
        List<AccountEntity> accountEntities = accountRepository.findAll();
        System.out.println("======================");
        accountEntities.forEach(a -> System.out.println(
                a.getUser_Id()
        ));
        boolean isIdDuplicated = accountEntities.stream()
                .anyMatch(p -> p.getUser_Id().equals(request.getUser_Id()));
        if (isIdDuplicated) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUser_Id(request.getUser_Id());
        accountEntity.setUser_Pwd(request.getUser_Pwd());
        accountEntity.setUser_Name(request.getUser_Name());
        accountEntity.setUser_Email(request.getUser_Email());
        System.out.println("======================");
        System.out.println(accountEntity.toString());
        System.out.println("======================");
        accountRepository.save(accountEntity);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{user_id}")
                .buildAndExpand(accountEntity.getUser_Id())
                .toUri();
        return ResponseEntity.created(location).body(accountEntity);
    }

}
