package com.example.Reservation.service;

import com.example.Reservation.entity.ReservationEntity;

import com.example.Reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Id;

import java.sql.Timestamp;
import java.util.Collection;

@Service
public class AddReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public ReservationEntity saveInfo()
    {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setUser_Id("blueway8099");
        reservationEntity.setStart_Date(timestamp);
        reservationEntity.setEnd_Date(timestamp);
        reservationEntity.setContent("打掃");
        return reservationRepository.saveAndFlush(reservationEntity);

    }

}
