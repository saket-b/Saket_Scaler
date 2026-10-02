package ParkingLot.Models;

import java.util.List;

public class ParkingSlot extends  BaseClass {

    private String number;
    private ParkingSlotStatus status;
    private List<VehicleTypeAllowed>vehicleTypeAllowed;

    public ParkingSlot(String number, ParkingSlotStatus status, List<VehicleTypeAllowed> vehicleTypeAllowed) {
        this.number = number;
        this.status = status;
        this.vehicleTypeAllowed = vehicleTypeAllowed;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ParkingSlotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSlotStatus status) {
        this.status = status;
    }

    public List<VehicleTypeAllowed> getVehicleTypeAllowed() {
        return vehicleTypeAllowed;
    }

    public void setVehicleTypeAllowed(List<VehicleTypeAllowed> vehicleTypeAllowed) {
        this.vehicleTypeAllowed = vehicleTypeAllowed;
    }
}
