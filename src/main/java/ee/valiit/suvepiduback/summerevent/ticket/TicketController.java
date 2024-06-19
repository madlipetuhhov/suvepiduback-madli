package ee.valiit.suvepiduback.summerevent.ticket;

import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketInfo;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController

public class TicketController {
    private final TicketService ticketService;

    @PostMapping("/ticket")
    @Operation(summary = "Create a new event ticket by eventDetailId.",
            description = "Creates a new event ticket in the database using the provided event ticket object (JSON payload) and eventDetailId (query parameter).")
    public void addTickets(@RequestParam Integer eventDetailId, @RequestBody EventTicketRequest eventTicketRequest) {
        ticketService.addEventTickets(eventDetailId, eventTicketRequest);
    }

    @GetMapping("/ticket")
    @Operation(summary = "Retrieve an event ticket by eventTicketId.",
            description = "Retrieves an event ticket from the database based on the eventTicketId (query parameter). Returns JSON containing event ticket info.")
    public EventTicketInfo getEventTicket(@RequestParam Integer eventTicketId) {
        return ticketService.getEventTicket(eventTicketId);
    }

    @GetMapping("/tickets")
    @Operation(summary = "Retrieve an array of event tickets by eventDetailId.",
            description = "Retrieves an array of event tickets from the database based on the eventDetailId (query parameter) and checks for active status. Returns an array of event tickets.")
    public List<EventTicketInfo> getEventTickets(@RequestParam Integer eventDetailId) {
        return ticketService.getEventTickets(eventDetailId);
    }

    @PutMapping("/ticket")
    @Operation(summary = "Update an event ticket.",
            description = "Updates an existing event ticket in the database based on the provided event ticket object (JSON payload).")
    public void editEventTicket(@RequestBody EventTicketInfo eventTicketInfo) {
        ticketService.editEventTicket(eventTicketInfo);
    }

    @DeleteMapping("/ticket")
    @Operation(summary = "Delete an event ticket by eventTicketId.",
            description = "The event ticket is not deleted from the database but deactivated based on the eventTicketId (query parameter). Returns eventTicketId as Integer.")
    public Integer removeEventTicket(@RequestParam Integer eventTicketId) {
        return ticketService.removeEventTicket(eventTicketId);
    }

}
