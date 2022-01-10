package com.example.reservation.repository;

import com.example.reservation.entity.AccountEntity;
import com.example.reservation.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeleteReservationRepository extends JpaRepository<ReservationEntity,Integer> {
    @Query(value ="delete from reservation_table a where a.id:id",nativeQuery = true)
    List<AccountEntity> deleteUser(@Param("id")Integer id);
}
