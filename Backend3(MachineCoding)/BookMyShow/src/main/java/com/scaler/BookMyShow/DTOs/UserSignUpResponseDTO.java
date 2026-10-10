package com.scaler.BookMyShow.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpResponseDTO {

    private Long userId;
    private String message;
    private ResponseStatus responseStatus;

}
