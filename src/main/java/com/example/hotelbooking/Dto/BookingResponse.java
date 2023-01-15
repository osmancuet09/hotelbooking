package com.example.hotelbooking.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingResponse {
    String reservationId;
    String getReservationProcess;
    String cancelReservationProcess;
}
