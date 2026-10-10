package BookMyShow;

import java.util.List;

public class Screen {
    private String name;
    private ScreenType screenType;
    private List<Show> showList;
    private List<Seat>seats;
    private List<SeatType> seatTypeList;
    private ScreenStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public void setScreenType(ScreenType screenType) {
        this.screenType = screenType;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<SeatType> getSeatTypeList() {
        return seatTypeList;
    }

    public void setSeatTypeList(List<SeatType> seatTypeList) {
        this.seatTypeList = seatTypeList;
    }

    public ScreenStatus getStatus() {
        return status;
    }

    public void setStatus(ScreenStatus status) {
        this.status = status;
    }
}
