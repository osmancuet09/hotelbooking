package com.example.hotelbooking.reservationapi;

import com.example.hotelbooking.Dto.BookingInfo;
import com.example.hotelbooking.Dto.BookingRequest;
import com.example.hotelbooking.Dto.BookingResponse;
import com.example.hotelbooking.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ReservationController {

    private final ReservationService reservationService;
    @Autowired
    ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @PostMapping("/booking")
    ResponseEntity createBooking(@RequestBody BookingRequest newBooking) {
        try {
            BookingResponse bookingResponse = reservationService.makeReservation(newBooking);
            if(bookingResponse==null){
                return new ResponseEntity<>(new String("Presidencial suite is not available for this date range"),HttpStatus.BAD_REQUEST);
            }
            bookingResponse.setMessage(new String("Please preserve the reservationId for show the reservation status or cancel reservation"));
            return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
        }
        catch (ObjectOptimisticLockingFailureException e){
            return new ResponseEntity<>(new String("Conflict with other reservation, please try a moment latter"),HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/booking/{id}")
    ResponseEntity getBooking(@PathVariable UUID id) {
        BookingInfo bookingInfo = reservationService.getReservationInfo(id);
        if(bookingInfo==null){
            return new ResponseEntity<>(new String("Reservation information not found"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookingInfo, HttpStatus.OK);
    }

    @PutMapping("/booking/{id}")
    ResponseEntity cancelBooking(@PathVariable UUID id) {
        String response = reservationService.cancelReservation(id);
        if(response==null){
            return new ResponseEntity<>(new String("Reservation information not found"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
