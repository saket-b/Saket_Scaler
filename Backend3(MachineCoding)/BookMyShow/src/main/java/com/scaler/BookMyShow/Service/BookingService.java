package com.scaler.BookMyShow.Service;

import com.scaler.BookMyShow.models.*;
import com.scaler.BookMyShow.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    ShowSeatTypeRepository showSeatTypeRepository;

    public Booking reserveBooking(Long userId, Long showId, List<Long> showSeatIds) throws IllegalAccessException{

        // Get a user with userID from user repository
        Optional<User> optionalUser = userRepository.findById(userId);
        if( optionalUser.isEmpty())
        {
            throw  new IllegalAccessException("Invalid user");
        }
        User user = optionalUser.get();
        //Get Show with showId from show repository
        Optional<Show>optionalShow = showRepository.findById(showId);
        if( optionalShow.isEmpty()){
            throw new IllegalAccessException("Invalid show");
        }

        Show show = optionalShow.get();

        List<ShowSeat> validShowSeats = checkAvailabilityAndLock(show, showSeatIds);

        // calculate price of tickets TO DO
        Integer amount = 0;
        for (ShowSeat showSeat : validShowSeats)
        {
            SeatType seatType = showSeat.getSeat().getType();
            ShowSeatType showSeatType = showSeatTypeRepository.findShowSeatTypeByShowAndSeatType(show, seatType);
            amount += showSeatType.getPrice();
        }


        // create the booking with bookingStatus as in-progress
        Booking booking = new Booking();
        booking.setBookingNumber(Booking.ticketNumberGenerator());
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);
        booking.setUser(user);
        booking.setShow(show);
        booking.setPrice(amount);  // to do
        booking.setShowSeats(validShowSeats);
        return bookingRepository.save(booking);

    }

    //@Transactional(isolation = Isolation.SERIALIZABLE)
    public  List<ShowSeat> checkAvailabilityAndLock(Show show, List<Long> showSeatIds){
        // -------start Lock-----
        // Get all show seats - IF the showSaets belong to same show
        //option 1 : throw Error if there are showseats with multiple shows
        //option2 : just proceed with the showseats from the mentioned show

        // Get all Show seats with showSeatIds from showRepository
        List<ShowSeat>showSeats = showSeatRepository.findAllById(showSeatIds);
        List<ShowSeat> validShowSeats = new ArrayList<>();
        for( ShowSeat showSeat : showSeats)
        {
            if( showSeat.getShow().getId().equals(show.getId())){
                validShowSeats.add(showSeat);
            }

        }
        System.out.println("Valid show seats : " + showSeats);

        if( validShowSeats.isEmpty() || validShowSeats.size() > 10)
        {
            throw  new IllegalArgumentException("Invalid seat selection");
        }

        // check if all showSeats are available
        // if not
        //    if booked -> throw an error , saying seats are already booked
        // if loacked - then we  check loackedAt time,
        // if ( currTime - lockAt > 5) then update the locked at time
        // else throw error
        // if yes , mark then locked and update the showeats are locked

        for(ShowSeat showSeat : validShowSeats)
        {
            if( showSeat.getShowSeatStatus().equals(ShowSeatStatus.LOCKED))
            {
                Long timePassedInMins = Duration.between(
                        new Date().toInstant(),
                        showSeat.getLockAt().toInstant()
                        ).toMinutes();
                if( timePassedInMins < 5) {
                    throw new IllegalArgumentException("Invalid seat Selection : seats are on hold , Please try again later !");
                }
            }

            // Available , LOCKED( with lock time greater than 5 minutes)
            showSeat.setLockAt(new Date());
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);

        }
        showSeatRepository.saveAll(validShowSeats);
        return validShowSeats;
        // ------  RELEASE THE LOCK -------
    }
}











