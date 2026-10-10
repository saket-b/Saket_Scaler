package com.scaler.BookMyShow.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

// Booking is a Ticket
@Entity
public class Booking extends BaseModel {

    // Ticket M : 1 : user
    @ManyToOne
    private User user;
    private String bookingNumber;
    private Integer price;
    @ManyToOne
    private Show show;
    // Booking 1: M Payment
    @OneToMany(mappedBy = "booking")
    private List<Payment> paymentList;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @OneToMany ( mappedBy = "booking")
    private List<ShowSeat> showSeats;


    private static int count = 1;

    public static String ticketNumberGenerator(){
        String bookingNumber =  "Booking_"+count;
        count++;
        return bookingNumber;
    }

}
