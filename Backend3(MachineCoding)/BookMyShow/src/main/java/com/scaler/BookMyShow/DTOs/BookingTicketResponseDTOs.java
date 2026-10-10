package com.scaler.BookMyShow.DTOs;


import com.scaler.BookMyShow.models.Booking;
import com.scaler.BookMyShow.models.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingTicketResponseDTOs {

    Long bookingId;
    String message;
    BookingStatus bookingStatus;
    Integer amount;
    ResponseStatus responseStatus;


}