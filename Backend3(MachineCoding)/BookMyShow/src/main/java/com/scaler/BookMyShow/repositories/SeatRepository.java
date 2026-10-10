package com.scaler.BookMyShow.repositories;

import com.scaler.BookMyShow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
