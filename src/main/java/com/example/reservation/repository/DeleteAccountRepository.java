package com.example.reservation.repository;

import com.example.reservation.entity.AccountEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeleteAccountRepository extends JpaRepository<AccountEntity,Long> {
    @Query(value ="delete from account_table a where a.id:id",nativeQuery = true)
    List<AccountEntity> deleteUser(@Param("id")Long id);
}
