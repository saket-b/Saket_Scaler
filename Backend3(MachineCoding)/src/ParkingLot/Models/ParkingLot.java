package ParkingLot.Models;

import java.util.List;

public class ParkingLot  extends  BaseClass{
    private String name;
    private List<ParkingFloor> floors;
    private  ParkiongLotStatus status;
    private  List<VehicleTypeAllowed> vehicleTypeAllowed;
    private List<Gate>entry_gates;
    private List<Gate>exit_gates;
    private FreeCalculationType fee_calculation_type;
    private SlotAllocationType slotAllocationType;


    public ParkingLot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehicleTypeAllowed(List<VehicleTypeAllowed> vehicleTypeAllowed) {
        this.vehicleTypeAllowed = vehicleTypeAllowed;
    }

    public List<Gate> getEntry_gates() {
        return entry_gates;
    }

    public void setEntry_gates(List<Gate> entry_gates) {
        this.entry_gates = entry_gates;
    }

    public List<Gate> getExit_gates() {
        return exit_gates;
    }

    public void setExit_gates(List<Gate> exit_gates) {
        this.exit_gates = exit_gates;
    }

    public FreeCalculationType getFee_calculation_type() {
        return fee_calculation_type;
    }

    public void setFee_calculation_type(FreeCalculationType fee_calculation_type) {
        this.fee_calculation_type = fee_calculation_type;
    }

    public SlotAllocationType getSlotAllocationType() {
        return slotAllocationType;
    }

    public void setSlotAllocationType(SlotAllocationType slotAllocationType) {
        this.slotAllocationType = slotAllocationType;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public ParkiongLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkiongLotStatus status) {
        this.status = status;
    }

    public List<VehicleTypeAllowed> getVehicleTypeAllowed() {
        return vehicleTypeAllowed;
    }
}
