package BookMyShow;

import ParkingLot.Models.Payment;

import java.util.List;

public class Ticket {
    private String number;
    private List<ShowSeat> showSeatList;
    private User user;
    private TicketStatus status;
    private Double amount;
    private Show show;
    private List<Payment> paymentList;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<ShowSeat> getShowSeatList() {
        return showSeatList;
    }

    public void setShowSeatList(List<ShowSeat> showSeatList) {
        this.showSeatList = showSeatList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}
