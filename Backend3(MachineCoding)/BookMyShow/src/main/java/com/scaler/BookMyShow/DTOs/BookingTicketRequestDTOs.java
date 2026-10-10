package com.scaler.BookMyShow.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BookingTicketRequestDTOs {
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;

}
