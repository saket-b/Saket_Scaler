package com.scaler.BookMyShow.Controller;

import com.scaler.BookMyShow.DTOs.BookingTicketRequestDTOs;
import com.scaler.BookMyShow.DTOs.BookingTicketResponseDTOs;
import com.scaler.BookMyShow.DTOs.ResponseStatus;
import com.scaler.BookMyShow.Service.BookingService;
import com.scaler.BookMyShow.models.Booking;
import com.scaler.BookMyShow.models.BookingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLOutput;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;



    public BookingTicketResponseDTOs bookingTicket(BookingTicketRequestDTOs requestDTOs)
    {
        BookingTicketResponseDTOs responseDTOs = new BookingTicketResponseDTOs();
        try{
            Booking booking = bookingService.reserveBooking(
                    requestDTOs.getUserId(),
                    requestDTOs.getShowId(),
                    requestDTOs.getShowSeatIds()
            );
            System.out.println("Booking ID inside BookingController : " + booking.getId());
            booking.setBookingStatus(BookingStatus.SUCCESS);
            responseDTOs.setBookingId(booking.getId());
            responseDTOs.setAmount(booking.getPrice());
            responseDTOs.setBookingStatus(booking.getBookingStatus());

            responseDTOs.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTOs.setMessage("Seat Selection successful , Please compte the payment for confirming your booking");
        }
        catch (Exception e)
        {
            System.out.println("Seat selection failed! - " + e.getMessage());
            responseDTOs.setBookingId(null);
            responseDTOs.setMessage("Seat selection failed");
            responseDTOs.setBookingStatus(BookingStatus.FAILURE);
            responseDTOs.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTOs;
    }

}
