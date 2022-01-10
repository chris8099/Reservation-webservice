package com.example.Reservation.controller;
import com.example.Reservation.entity.AccountEntity;
import com.example.Reservation.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping(value="/userall" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class SelectAccountController {
    @Autowired
    AccountRepository accountRepository;
    @GetMapping
    public ResponseEntity <List<AccountEntity> >selectAll (@RequestParam(value = "user_id", defaultValue = "") String name){
          List<AccountEntity> accountEntities = accountRepository.findAll().
                  stream().filter(p->p.getUser_Id().toUpperCase().contains(name.toUpperCase())).collect(Collectors.toList());
          return ResponseEntity.ok().body(accountEntities);
    }



}
