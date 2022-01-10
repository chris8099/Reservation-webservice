package com.example.Reservation.controller;

import com.example.Reservation.entity.ReservationEntity;
import com.example.Reservation.repository.DeleteAccountRepository;
import com.example.Reservation.repository.DeleteReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteReservationController {
    @Autowired
    DeleteReservationRepository deleteReservationRepository;
    @RequestMapping("/delete_reservation")
    public String DeleteReservation(@RequestParam("id") Integer id)
    {
        deleteReservationRepository.deleteById(id);
        return "done";
    }
}
