package com.scaler.BookMyShow;

import com.scaler.BookMyShow.Controller.BookingController;
import com.scaler.BookMyShow.Controller.UserController;
import com.scaler.BookMyShow.DTOs.*;
import com.scaler.BookMyShow.models.*;
import com.scaler.BookMyShow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BookMyShowApplication  implements CommandLineRunner {

	@Autowired
	private UserController userController;

	@Autowired
	private  CityRepository cityRepository;

	@Autowired
	private TheatreRepository theatreRepository;

	@Autowired
	private ScreenRepository screenRepository;

	@Autowired
	private SeatRepository seatRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ShowRepository showRepository;

	@Autowired
	private ShowSeatRepository showSeatRepository;

	@Autowired
	private ShowSeatTypeRepository showSeatTypeRepository;

	@Autowired
	private BookingController bookingController;

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

	void dataSetup(){

		// Add city
		City city = new City();
		city.setName("Banglore");
		cityRepository.save(city);

		// add one theatre to city
		Theatre theatre1 = new Theatre();
		theatre1.setName("Phoenix mall");
		theatre1.setCity(city);
		theatreRepository.save(theatre1);

		// add one screen in the theatre
		Screen screen1 = new Screen();
		screen1.setName("Screen 1");
		screen1.setTheatre(theatre1);
		screenRepository.save(screen1);

		// add four seats o the screen

		Seat seat1 = new Seat(); seat1.setName("1A"); seat1.setType(SeatType.GOLD);
		Seat seat2 = new Seat(); seat2.setName("2A"); seat2.setType(SeatType.PREMIUM);
		Seat seat3 = new Seat(); seat3.setName("3A"); seat3.setType(SeatType.GOLD);
		Seat seat4 = new Seat(); seat4.setName("4A"); seat4.setType(SeatType.PREMIUM);
		seatRepository.saveAll(List.of(seat1, seat2, seat3, seat4));
		screen1.setSeats(List.of(seat1, seat2, seat3, seat4));
		screenRepository.save(screen1);

		// multiple theatre setting
		theatre1.setScreens(List.of(screen1));
		theatreRepository.save(theatre1);

		// multiple city setting
		city.setTheatreList(List.of(theatre1));
		cityRepository.save(city);

		// create 1 movie
		Movie movie1 = new Movie();
		movie1.setName("obsession");
		movie1.setGenre("Thriller");
		movieRepository.save(movie1);

		// create Show
		Show show9am = new Show();
		show9am.setTheatre(theatre1);
		show9am.setMovie(movie1);
		show9am.setScreen(screen1);
		showRepository.save(show9am);
		List<ShowSeat> showSeats = new ArrayList<>();
		for( Seat seat : screen1.getSeats())
		{
			ShowSeat showSeat = new ShowSeat();
			showSeat.setShow(show9am);
			showSeat.setSeat(seat);
			showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
			showSeats.add(showSeat);
		}
		showSeatRepository.saveAll(showSeats);

		List<ShowSeatType> showSeatTypes = new ArrayList<>();
		for(SeatType seatType : SeatType.values())
		{
			ShowSeatType showSeatType = new ShowSeatType();
			showSeatType.setShow(show9am);
			showSeatType.setSeatType(seatType);
			if( seatType.equals(SeatType.GOLD)){
				showSeatType.setPrice(300);
			}
			else if( showSeatType.equals(SeatType.PREMIUM))
			{
				showSeatType.setPrice(200);
			}
			showSeatTypes.add(showSeatType);
		}

		showSeatTypeRepository.saveAll(showSeatTypes);

		show9am.setShowSeatList(showSeats);
		show9am.setShowSeatTypes(showSeatTypes);
		showRepository.save(show9am);





	}

	@Override
	public void run(String... args) throws Exception{

		// signUp DTOs
		// user1
//		UserSignUpRequestDTO userSignUpRequestDTO = new UserSignUpRequestDTO();
//		userSignUpRequestDTO.setName("Saket");
//		userSignUpRequestDTO.setEmail("saket@gmail.com");
//		userSignUpRequestDTO.setPassword("12345");
//
//		UserSignUpResponseDTO userSignUpResponseDTO = userController.signUp(userSignUpRequestDTO);
//		if( userSignUpResponseDTO.getResponseStatus().equals(ResponseStatus.FAILURE))
//			System.out.println("Error - " +  userSignUpResponseDTO.getMessage());
//		else
//			System.out.println("user sign up succeful " + userSignUpResponseDTO.getUserId());
//
//		// user 2
//		UserSignUpRequestDTO requestDTO = new UserSignUpRequestDTO();
//		requestDTO.setName("Milan");
//		requestDTO.setPassword("somepassword");
//		requestDTO.setEmail("milan@email.com");
//		UserSignUpResponseDTO responseDTO = userController.signUp(requestDTO);
//		responseDTO = userController.signUp(requestDTO);
//		if(responseDTO.getResponseStatus().equals(ResponseStatus.FAILURE)){
//			System.out.println("Error - " + responseDTO.getMessage());
//		}else{
//			System.out.println("User sign up succesfull " + responseDTO.getUserId());
//		}

		//dataSetup();

		BookingTicketRequestDTOs requestDTOs = new BookingTicketRequestDTOs();
		requestDTOs.setUserId(1L);
		requestDTOs.setShowId(1L);
		requestDTOs.setShowSeatIds(List.of(3L, 4L));
		BookingTicketResponseDTOs bookingTicketResponseDTOs = bookingController.bookingTicket(requestDTOs);
		if( bookingTicketResponseDTOs.getResponseStatus().equals(ResponseStatus.SUCCESS))
		{
			System.out.println("Booking Successfull with ID : "+ bookingTicketResponseDTOs.getBookingId() + " and amount " + bookingTicketResponseDTOs.getAmount());
		}
		else
		{
			System.out.println("Error : " + bookingTicketResponseDTOs.getMessage());
		}







	}
}
