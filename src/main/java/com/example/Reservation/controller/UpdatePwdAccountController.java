package com.example.Reservation.controller;

import com.example.Reservation.entity.AccountEntity;
import com.example.Reservation.repository.AccountRepository;
import com.example.Reservation.repository.DeleteReservationRepository;
import com.example.Reservation.repository.UpdatePwdAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/update_pwd")
public class UpdatePwdAccountController {
    @Autowired
    private UpdatePwdAccountRepository updateAccountRepository;
    @Autowired
    private AccountRepository accountRepository;
    @PutMapping("/{user_Id}")
    public ResponseEntity<AccountEntity> updateUserInfo(@PathVariable("user_Id") String user_Id, @RequestBody AccountEntity request)
    {
        List<AccountEntity> accountEntityList = accountRepository.findAll();
        Optional<AccountEntity> accountEntityOptional = accountEntityList.stream().filter(p->p.getUser_Id().equals(user_Id)).findFirst();
        if(accountEntityOptional.isPresent())
        {
            AccountEntity accountEntity = accountEntityOptional.get();
            accountEntity.setUser_Pwd(request.getUser_Pwd());
            accountRepository.saveAndFlush(accountEntity);
            return ResponseEntity.ok().body(accountEntity);
        }
      //  updateAccountRepository.updateOne(user_pwd,user_Id);
        return ResponseEntity.notFound().build();
    }
}
