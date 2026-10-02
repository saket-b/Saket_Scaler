package ParkingLot.controllers;

import ParkingLot.DTOs.IssueTicketRequestDTO;
import ParkingLot.DTOs.IssueTicketResponseDTO;
import ParkingLot.Models.ResponseStatus;
import ParkingLot.Models.Ticket;
import ParkingLot.Service.TicketService;

public class TicketController {

    TicketService ticketService;
    //Depedency injection

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO createTicket(IssueTicketRequestDTO requestDTO)
    {
        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();
        try{
            // Input Format & Call service
            // User user = userService.authenticate(requestDTO.getUserToken());
            Ticket ticket = ticketService.createTicket(
                    requestDTO.getGateId(),
                    requestDTO.getVehicleNo(),
                    requestDTO.getOwnerName(),
                    requestDTO.getOwnerNumber(),
                    requestDTO.getVehicleType()
            );
            //output format
            responseDTO.setStatus(ResponseStatus.SUCCESS);
            responseDTO.setResponseMessage("Ticket created successfully");
            responseDTO.setTicketNo(ticket.getT_number());
            responseDTO.setEntryTime(ticket.getEntry_time());
            responseDTO.setParkingSlotNumber(ticket.getParkingSlot().getNumber());
            return responseDTO;

        }
        catch (Exception e)
        {
            //Error format
            responseDTO.setResponseMessage(e.getMessage());
            responseDTO.setStatus(ResponseStatus.FAILURE);
            System.out.println("Error in creating ticket - " + e.getMessage());
            return responseDTO;
        }
    }
}
