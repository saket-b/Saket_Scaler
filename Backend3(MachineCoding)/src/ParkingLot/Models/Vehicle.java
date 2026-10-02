package ParkingLot.Models;

public class Vehicle  extends  BaseClass{

    private String RegNo;
    private String OwnerName;
    private VehicleType vehicleType;
    private String ownerContact;

    public Vehicle(String regNo, String ownerName, VehicleType vehicleType, String ownerContact) {
        RegNo = regNo;
        OwnerName = ownerName;
        this.vehicleType = vehicleType;
        this.ownerContact = ownerContact;
    }

    public String getOwnerContact() {
        return ownerContact;
    }

    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }

    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String regNo) {
        RegNo = regNo;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
