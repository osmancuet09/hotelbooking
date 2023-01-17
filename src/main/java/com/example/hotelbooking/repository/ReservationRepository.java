package com.example.hotelbooking.repository;

import com.example.hotelbooking.entity.PresidentialSuitOfADay;
import com.example.hotelbooking.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.UUID;

public interface ReservationRepository  extends JpaRepository<Reservation, Long> {
    @Query(value = "SELECT r FROM Reservation r WHERE r.reservationId= :reservationId")
    Reservation findByReservationId(@Param("reservationId") UUID reservationId);
}
