package com.example.reservation.controller;

import com.example.reservation.repository.DeleteReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
