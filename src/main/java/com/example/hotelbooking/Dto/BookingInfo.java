package com.example.hotelbooking.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class BookingInfo {
    String email;
    String firstName;
    String lastName;
    Integer guestCount;
    Date startDate;
    Date endDate;
}
