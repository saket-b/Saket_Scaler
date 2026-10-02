package ParkingLot;

import ParkingLot.DTOs.IssueTicketRequestDTO;
import ParkingLot.DTOs.IssueTicketResponseDTO;
import ParkingLot.Models.*;
import ParkingLot.Repositories.GateRepository;
import ParkingLot.Repositories.ParkingLotRepository;
import ParkingLot.Repositories.VehicleRpository;
import ParkingLot.Service.TicketService;
import ParkingLot.controllers.TicketController;

import java.util.ArrayList;
import java.util.List;

public class Client {
    static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRpository vehicleRpository = new VehicleRpository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        TicketService ticketService = new TicketService(gateRepository, vehicleRpository);
        TicketController ticketController = new TicketController(ticketService);
        //Generate some pre data
        // some gates , a parking lot , a parking some parking slots
        Operator operator = new Operator("Akash", "NT155");
        Gate gateEntry1 = new Gate(1, GateType.ENTRY, GateStatus.OPEN, operator);
        Gate gateEntry2 = new Gate(2, GateType.ENTRY, GateStatus.OPEN, operator);
        Gate gateExit1 = new Gate(3, GateType.EXIT, GateStatus.OPEN, operator);
        Gate gateExit2 = new Gate(4, GateType.EXIT, GateStatus.OPEN, operator);

        ParkingLot parkingLot = new ParkingLot("Prestige Tech Park");
        parkingLot.setStatus(ParkiongLotStatus.EMPTY);
        gateEntry1.setParkingLot(parkingLot);
        gateEntry2.setParkingLot(parkingLot);
        gateExit1.setParkingLot(parkingLot);
        gateExit2.setParkingLot(parkingLot);

        // Entry gates
        List<Gate> entryGates = new ArrayList<>();
        entryGates.add(gateEntry1);
        entryGates.add(gateEntry2);
        parkingLot.setEntry_gates(entryGates);

        // Exit gates
        List<Gate> exitGates = new ArrayList<>();
        exitGates.add(gateExit1);
        exitGates.add(gateExit2);
        parkingLot.setExit_gates(exitGates);

        // Allocation Strategy Type
        parkingLot.setSlotAllocationType(SlotAllocationType.RANDOM);

        //parkingLot id
        parkingLot.setId(123456L);


        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setFloor_number(1);
        parkingFloor.setStatus(FloorStatus.OPEN);

        List<ParkingSlot>parkingSlots = new ArrayList<>();

        List<VehicleTypeAllowed>av1List = new ArrayList<>();
        av1List.add(new VehicleTypeAllowed(VehicleType.BIKE, 3));

        List<VehicleTypeAllowed>av2List = new ArrayList<>();
        av2List.add(new VehicleTypeAllowed(VehicleType.CAR, 1));

        List<VehicleTypeAllowed>av3List = new ArrayList<>();
        av3List.add(new VehicleTypeAllowed(VehicleType.BIKE, 1));

        List<VehicleTypeAllowed>av4List = new ArrayList<>();
        av4List.add(new VehicleTypeAllowed(VehicleType.CAR, 1));


        parkingSlots.add( new ParkingSlot("1", ParkingSlotStatus.EMPTY, av1List));
        parkingSlots.add( new ParkingSlot("2", ParkingSlotStatus.EMPTY, av2List));
        parkingSlots.add( new ParkingSlot("3", ParkingSlotStatus.EMPTY, av3List));
        parkingSlots.add( new ParkingSlot("4", ParkingSlotStatus.EMPTY, av4List));
        parkingFloor.setSlots(parkingSlots);


        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        parkingFloorList.add(parkingFloor);

        parkingLot.setFloors(parkingFloorList);
        gateEntry1.setParkingLot(parkingLot);
        gateEntry2.setParkingLot(parkingLot);
        gateExit1.setParkingLot(parkingLot);
        gateExit2.setParkingLot(parkingLot);


        gateRepository.save(gateEntry1);
        gateRepository.save(gateEntry2);
        gateRepository.save(gateExit1);
        gateRepository.save(gateExit2);

        parkingLotRepository.save(parkingLot);

        IssueTicketRequestDTO requestDTO = new IssueTicketRequestDTO();
        requestDTO.setGateId(1L);
        requestDTO.setOwnerName("Ram");
        requestDTO.setOwnerNumber("00000000");
        requestDTO.setVehicleNo("BR1659");
        requestDTO.setVehicleType(VehicleType.CAR);

        // request response
        IssueTicketResponseDTO issueTicketResponseDTO = ticketController.createTicket(requestDTO);

        if( issueTicketResponseDTO.getStatus().equals(ResponseStatus.SUCCESS)) {
            System.out.println(issueTicketResponseDTO.getResponseMessage());
            System.out.println("Ticket : " + requestDTO.getVehicleNo() + " at slot :" + issueTicketResponseDTO.getParkingSlotNumber());
        }
        else
        {
            System.out.println(issueTicketResponseDTO.getResponseMessage());
        }

        System.out.println("\n");

        IssueTicketRequestDTO requestDTO2 = new IssueTicketRequestDTO();
        requestDTO2.setGateId(1L);
        requestDTO2.setOwnerName("Ram");
        requestDTO2.setOwnerNumber("00000000");
        requestDTO2.setVehicleNo("BR1659");
        requestDTO2.setVehicleType(VehicleType.CAR);

        // request response
        IssueTicketResponseDTO issueTicketResponseDTO2 = ticketController.createTicket(requestDTO2);

        if( issueTicketResponseDTO2.getStatus().equals(ResponseStatus.SUCCESS)) {
            System.out.println(issueTicketResponseDTO2.getResponseMessage());
            System.out.println("Ticket : " + requestDTO2.getVehicleNo() + " at slot :" + issueTicketResponseDTO2.getParkingSlotNumber());
        }
        else
        {
            System.out.println(issueTicketResponseDTO2.getResponseMessage());
        }





        


    }
}
