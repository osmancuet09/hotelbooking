package com.example.hotelbooking.reservationapi;

import com.example.hotelbooking.Dto.BookingInfo;
import com.example.hotelbooking.Dto.BookingRequest;
import com.example.hotelbooking.Dto.BookingResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    @PostMapping("/booking")
    ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest newBooking) {
        return new ResponseEntity<>(new BookingResponse(), HttpStatus.OK);
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
