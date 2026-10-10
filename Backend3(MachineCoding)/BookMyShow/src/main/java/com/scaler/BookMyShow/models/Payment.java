package com.scaler.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Payment extends  BaseModel{

    @ManyToOne
    private  User user;
    @ManyToOne
    private  Booking booking;
    private  Integer amount;
    private  String transaction_id;
    @Enumerated(EnumType.STRING)
    private  PaymentMode paymentMode;
    @Enumerated(EnumType.STRING)
    private  PaymentStatus status;

}
