package ParkingLot.Strategy;

import ParkingLot.Models.SlotAllocationType;

public class SlotAllocationStartegyFactory {
    public static SlotAllocationStrategy getStrategy(SlotAllocationType slotAllocationType)
    {
        if(slotAllocationType.equals(slotAllocationType.RANDOM))
        {
            return new RandomSlotAllocationStrategy();
        }
        else
        {
            throw new IllegalArgumentException("Invalid slotAllocationType");
        }
    }
}
