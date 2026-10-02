package ParkingLot.Strategy;

import ParkingLot.Models.*;

import java.util.List;
import java.util.Optional;

public class RandomSlotAllocationStrategy implements SlotAllocationStrategy{
    @Override
    public Optional<ParkingSlot> allocateSlot(ParkingLot parkingLot, VehicleType vehicleType) {

        System.out.println("Vehicle Type : " + vehicleType);
        for(ParkingFloor floor : parkingLot.getFloors())
        {
            for(ParkingSlot slot : floor.getSlots())
            {
                if( slot.getStatus().equals(ParkingSlotStatus.EMPTY))
                {
                    List<VehicleTypeAllowed>allowedVehicles = slot.getVehicleTypeAllowed();
                    for( VehicleTypeAllowed vehicleTypeAllowed : allowedVehicles)
                    {
                        System.out.println("Allowed vehicle - " + vehicleTypeAllowed.getType());
                        if( vehicleTypeAllowed.getType().equals(vehicleType)){
                           return Optional.of(slot);
                        }
                    }
                }
            }
        }

        return Optional.empty();
    }
}
