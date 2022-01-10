package com.example.Reservation.repository;

import com.example.Reservation.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpdatePwdAccountRepository extends JpaRepository<AccountEntity,Integer> {
@Query (value = "update account_table b set b.user_pwd=?1 where b.user_id=?2",nativeQuery = true)
@Modifying
    public void updateOne(String user_pwd,String user_id);
}
