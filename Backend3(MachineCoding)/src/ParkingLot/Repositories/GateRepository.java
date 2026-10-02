package ParkingLot.Repositories;

import ParkingLot.Models.Gate;

import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    private TreeMap<Long, Gate> gateTreeTable = new TreeMap<>();
    private Long id = 0l;

    public Gate save( Gate gate)
    {
        gate.setId(id++);
        gateTreeTable.put(gate.getId(), gate);
        return gate;
    }

    public Optional<Gate> getGateById(Long gateId)
    {
        return Optional.ofNullable(gateTreeTable.get(gateId));
    }
}
