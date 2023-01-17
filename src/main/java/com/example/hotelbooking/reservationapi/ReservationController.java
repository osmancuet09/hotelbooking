package com.example.hotelbooking.reservationapi;

import com.example.hotelbooking.Dto.BookingInfo;
import com.example.hotelbooking.Dto.BookingRequest;
import com.example.hotelbooking.Dto.BookingResponse;
import com.example.hotelbooking.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    private final ReservationService reservationService;
    @Autowired
    ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @PostMapping("/booking")
    ResponseEntity createBooking(@RequestBody BookingRequest newBooking) {
        BookingResponse bookingResponse = reservationService.makeReservation(newBooking);
        if(bookingResponse==null){
            return new ResponseEntity<>(new String("Presidencial suite is not available for this date range"),HttpStatus.BAD_REQUEST);
        }
        bookingResponse.setMessage(new String("Please preserve the reservationId for show the reservation status or cancel reservation"));
        return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
    }

    @GetMapping("/booking/{id}")
    ResponseEntity<BookingInfo> getBooking(@PathVariable String id) {
        return new ResponseEntity<>(new BookingInfo(), HttpStatus.OK);
    }

    @PutMapping("/booking/{id}")
    ResponseEntity<String> cancelBooking(@PathVariable String id) {
        return new ResponseEntity<>(new String("Reservation cancelled for Mr. Tommy"), HttpStatus.OK);
    }
}
