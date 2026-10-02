package ParkingLot.Service;

import ParkingLot.Models.*;
import ParkingLot.Repositories.GateRepository;
import ParkingLot.Repositories.VehicleRpository;
import ParkingLot.Strategy.SlotAllocationStartegyFactory;
import ParkingLot.Strategy.SlotAllocationStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService  {

    GateRepository gateRepository;
    VehicleRpository vehicleRpository;

    public TicketService(GateRepository gateRepository, VehicleRpository vehicleRpository) {
        this.gateRepository = gateRepository;
        this.vehicleRpository = vehicleRpository;
    }

    public Ticket createTicket(Long gateId, String vehicleNo, String ownerName, String ownerNo, VehicleType vehicleType)
    {
        // 1. Fetch the gate from DB
        Optional<Gate> optionalGate = gateRepository.getGateById(gateId);
        if(optionalGate.isEmpty())
        {
            throw new IllegalArgumentException("Invalid Gat ID");
        }
        Gate gate = optionalGate.get();

        //2. fetch operator from gate
        Operator operator = gate.getOperator();
        //3. FindOrCreat Vehicle from DB
        Vehicle vehicle = new Vehicle(vehicleNo, ownerName, vehicleType, ownerNo);
        vehicle = vehicleRpository.findByNumberOrCreate(vehicle);
        //4. Fetch the parkingLot
        ParkingLot parkingLot = gate.getParkingLot();

        //5. Assign the parkingSlot using the slot allocation strategy
        SlotAllocationStrategy slotAllocationStrategy = SlotAllocationStartegyFactory.getStrategy(parkingLot.getSlotAllocationType());
        Optional<ParkingSlot> optionalParkingSlot = slotAllocationStrategy.allocateSlot(parkingLot, vehicleType);
        if( optionalParkingSlot.isEmpty())
        {
            throw new IllegalArgumentException("Parking Slot unavailable");
        }
        ParkingSlot parkingSlot = optionalParkingSlot.get();

        //6. Update parking slot to be filled
        parkingSlot.setStatus(ParkingSlotStatus.FILLED);

        // 7. Create a ticket with all available info and return it.
        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setOperator(operator);
        ticket.setVehicle(vehicle);
        ticket.setParkingSlot(parkingSlot);
        ticket.setEntry_time(new Date());

        return ticket;
    }

}
