package ParkingLot.Repositories;

import ParkingLot.Models.Vehicle;

import java.util.Optional;
import java.util.TreeMap;

public class VehicleRpository {
    TreeMap<String, Vehicle> vehicleTable = new TreeMap<>();
    Long id = 0l;

    Vehicle save( Vehicle vehicle)
    {
        vehicle.setId(id++);
        vehicleTable.put(vehicle.getRegNo(), vehicle);
        return vehicle;
    }

    public Optional<Vehicle> findBynumber(String number)
    {
        return Optional.ofNullable(vehicleTable.get(number));
    }

    public Vehicle findByNumberOrCreate(Vehicle vehicle)
    {
        Optional<Vehicle> optional = findBynumber(vehicle.getRegNo());
        if( optional.isPresent())
        {
            return optional.get();
        }
        return save(vehicle);
    }

}
