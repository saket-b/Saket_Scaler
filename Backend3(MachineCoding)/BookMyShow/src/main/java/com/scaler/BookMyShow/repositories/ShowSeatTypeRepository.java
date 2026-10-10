package com.scaler.BookMyShow.repositories;

import com.scaler.BookMyShow.models.SeatType;
import com.scaler.BookMyShow.models.Show;
import com.scaler.BookMyShow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatTypeRepository  extends JpaRepository<ShowSeatType, Long> {
    ShowSeatType findShowSeatTypeByShowAndSeatType(Show show, SeatType seatType);
}
