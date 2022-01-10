package com.example.Reservation.controller;


import com.example.Reservation.entity.AccountEntity;
import com.example.Reservation.entity.ReservationEntity;
import com.example.Reservation.repository.ReservationRepository;
import com.example.Reservation.service.AddReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/new_reservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddReservationController {
    @Autowired
    ReservationRepository reservationRepository;
    @PostMapping
    public ResponseEntity<ReservationEntity> createReservation(@RequestBody ReservationEntity request) {
        List<ReservationEntity> reservationEntityList = reservationRepository.findAll();
        boolean isIdDuplicated = reservationEntityList.stream()
                .anyMatch(p -> p.getStart_Date().equals(request.getStart_Date()));
        if (isIdDuplicated) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setUser_Id(request.getUser_Id());
        reservationEntity.setStart_Date(request.getStart_Date());
        reservationEntity.setEnd_Date(request.getEnd_Date());
        reservationEntity.setContent(request.getContent());
        reservationRepository.saveAndFlush(reservationEntity);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{user_id}")
                .buildAndExpand(reservationEntity.getUser_Id())
                .toUri();
        return ResponseEntity.created(location).body(reservationEntity);
    }
}
