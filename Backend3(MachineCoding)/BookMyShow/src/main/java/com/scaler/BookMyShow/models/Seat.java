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
public class Seat extends BaseModel {

    private String name;
    private Integer row, col;
    @Enumerated(EnumType.STRING)
    private SeatStatus status;
    @Enumerated(EnumType.STRING)
    private SeatType type;
    @ManyToOne
    private Screen screen;

}
