package com.scaler.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.text.Format;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show  extends  BaseModel{
    //show M : 1 theatre
    @ManyToOne
    private Theatre theatre;
    // show m : 1 screen
    @ManyToOne
    private Screen screen;
    private Date startTime;
    private Date endTime;
    // show M : 1 movie
    @ManyToOne
    private Movie movie;
//    private Language language;
    private List<Feature> featureList; // feature both same
    // show 1: M showseat
    @OneToMany(mappedBy = "show")
    private List<ShowSeat>showSeatList;
    // show 1 : M ShowseatType
    @OneToMany(mappedBy = "show")
    private List<ShowSeatType> showSeatTypes;



}
