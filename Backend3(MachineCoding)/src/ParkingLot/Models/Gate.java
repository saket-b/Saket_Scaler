package ParkingLot.Models;

public class Gate  extends BaseClass{
    private Integer gate_no;
    private Operator operator;
    private GateStatus status;
    private GateType type;
    // extra added for some benifit
    private  ParkingLot parkingLot;

    public Gate(Integer gate_no, GateType type, GateStatus status, Operator operator) {
        this.type = type;
        this.status = status;
        this.operator = operator;
        this.gate_no = gate_no;
    }

    public Integer getGate_no() {
        return gate_no;
    }

    public void setGate_no(Integer gate_no) {
        this.gate_no = gate_no;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }

    public GateType getType() {
        return type;
    }

    public void setType(GateType type) {
        this.type = type;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
