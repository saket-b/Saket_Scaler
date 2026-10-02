package ParkingLot.DTOs;

import ParkingLot.Models.VehicleType;

public class IssueTicketRequestDTO {
    private String vehicleNo;
    private String ownerName;
    private String ownerNumber;
    private Long gateId;
    private VehicleType vehicleType;

    public IssueTicketRequestDTO() {
    }

    public IssueTicketRequestDTO(String vehicleNo, String ownerName, String ownerNumber, Long gateId) {
        this.vehicleNo = vehicleNo;
        this.ownerName = ownerName;
        this.ownerNumber = ownerNumber;
        this.gateId = gateId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
