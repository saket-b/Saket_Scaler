package ParkingLot.Models;

public class VehicleTypeAllowed extends BaseClass {
    private VehicleType type;
    private Integer capacity;

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public VehicleTypeAllowed(VehicleType type, Integer capacity) {
        this.type = type;
        this.capacity = capacity;


    }
}
