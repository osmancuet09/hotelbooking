package com.example.hotelbooking.repository;

import com.example.hotelbooking.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservationRepository  extends JpaRepository<Reservation, Long> {

}
