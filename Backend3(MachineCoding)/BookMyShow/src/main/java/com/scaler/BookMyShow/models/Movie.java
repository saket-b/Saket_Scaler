package com.scaler.BookMyShow.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
public class Movie extends  BaseModel{
    private String name;
    private Integer durationInMinutes;
    @Enumerated(EnumType.STRING)
    @ElementCollection // Primitive type List
    private List<Language>languages;
    @Enumerated(EnumType.STRING)
    @ElementCollection // Primitive type List
    private List<Feature>features;

    @ElementCollection
    private List<String>actors;
    private String genre;
}
