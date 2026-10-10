package com.scaler.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter

@Entity
public class Screen extends  BaseModel {

    private String name;
    @ManyToOne
    private Theatre theatre;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Feature> features;
    @OneToMany(mappedBy = "screen") // seat side table mapped with screen
    private List<Seat>seats;
    @Enumerated(EnumType.STRING)
    private  ScreenStatus status;

}
