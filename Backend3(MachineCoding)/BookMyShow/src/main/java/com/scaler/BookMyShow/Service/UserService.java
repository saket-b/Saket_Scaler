package com.scaler.BookMyShow.Service;

import com.scaler.BookMyShow.models.User;
import com.scaler.BookMyShow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User signUp(String name , String email, String password)
    {
        // fetch user with email and check if user exists or not
        Optional<User> optionalUser = userRepository.findByEmail(email);
        // if exists , throw exception
        if( optionalUser.isPresent())
        {
            throw  new IllegalArgumentException("Email is already exist!");
        }
        // else save the user data using user repository
        // encyption To Do
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        return userRepository.save(user);

    }
}
