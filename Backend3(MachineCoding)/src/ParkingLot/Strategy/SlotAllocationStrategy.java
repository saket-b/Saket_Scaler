package ParkingLot.Strategy;

import ParkingLot.Models.Operator;
import ParkingLot.Models.ParkingLot;
import ParkingLot.Models.ParkingSlot;
import ParkingLot.Models.VehicleType;

import java.util.Optional;

public interface SlotAllocationStrategy {
    public Optional<ParkingSlot> allocateSlot(ParkingLot parkingLot, VehicleType vehicleType);

}
