package ParkingLot.Models;


import java.util.List;

public class ParkingFloor extends  BaseClass{

    private Integer floor_number;
    private List<ParkingSlot> slots;
    private List<VehicleTypeAllowed> vehicleTypeAllowed;
    private FloorStatus status;


    public Integer getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(Integer floor_number) {
        this.floor_number = floor_number;
    }

    public List<VehicleTypeAllowed> getVehicleTypeAllowed() {
        return vehicleTypeAllowed;
    }

    public void setVehicleTypeAllowed(List<VehicleTypeAllowed> vehicleTypeAllowed) {
        this.vehicleTypeAllowed = vehicleTypeAllowed;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public void setSlots(List<ParkingSlot> slots) {
        this.slots = slots;
    }

    public FloorStatus getStatus() {
        return status;
    }

    public void setStatus(FloorStatus status) {
        this.status = status;
    }
}
