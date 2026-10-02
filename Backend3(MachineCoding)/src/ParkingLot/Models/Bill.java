package ParkingLot.Models;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Bill extends  BaseClass{

    private Integer num;
    private Ticket ticket;
    private DateTimeFormatter exit_time;
    private Double amount;
    private Gate gate;
    private Operator operator;
    private BillStatus status;
    private List<Payment> paymentTypes;


    public DateTimeFormatter getExit_time() {
        return exit_time;
    }

    public void setExit_time(DateTimeFormatter exit_time) {
        this.exit_time = exit_time;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public List<Payment> getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(List<Payment> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
