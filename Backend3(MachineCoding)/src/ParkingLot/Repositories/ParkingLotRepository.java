package ParkingLot.Repositories;

import ParkingLot.Models.ParkingLot;

import java.util.Date;
import java.util.TreeMap;

public class ParkingLotRepository {
    private TreeMap<Long, ParkingLot> parkingLotTable = new TreeMap<>();
    Long previousId =0l;

    public ParkingLot save(ParkingLot parkingLot)
    {
        parkingLot.setId(previousId++);
        parkingLot.setCreated_at(new Date());
        parkingLot.setUpdated_at(new Date());
        parkingLotTable.put(previousId, parkingLot);
        return parkingLot;
    }

}
