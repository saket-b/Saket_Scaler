package com.scaler.BookMyShow.Controller;

import com.scaler.BookMyShow.DTOs.ResponseStatus;
import com.scaler.BookMyShow.DTOs.UserSignUpRequestDTO;
import com.scaler.BookMyShow.DTOs.UserSignUpResponseDTO;
import com.scaler.BookMyShow.Service.UserService;
import com.scaler.BookMyShow.models.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Getter
@Setter

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public UserSignUpResponseDTO signUp(UserSignUpRequestDTO requestDTO)
    {
        UserSignUpResponseDTO responseDTO = new UserSignUpResponseDTO();
        try{

            User user = userService.signUp(
                    requestDTO.getName(),
                    requestDTO.getEmail(),
                    requestDTO.getPassword()
            );

            responseDTO.setUserId(user.getId());
            responseDTO.setMessage("User sign up successfullly");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);


        } catch (Exception e) {

            System.out.println("User sign up failed - " + e.getMessage());
            responseDTO.setMessage("User sign up failed");
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);

        }
        return responseDTO;
    }


}
