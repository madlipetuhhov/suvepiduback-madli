package ee.valiit.suvepiduback.summerevent.ticket;

import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketInfo;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketRequest;
import ee.valiit.suvepiduback.summerevent.tickettype.dto.TicketTypeInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController

public class TicketController {
    private final TicketService ticketService;

    @PostMapping("/ticket")
    @Operation(summary = "Sündmuse toimumiskohale piletite koguse ja saadavuse lisamine.",
            description = "Andmebaasi lisatakse sündmuse toimumiskohale juurde piletikogused ja saadavused (eventDetailId abil).")
    public void addTickets(@RequestBody EventTicketRequest eventTicketRequest) {
        ticketService.addTickets(eventTicketRequest);
    }

    @GetMapping("/ticket")
    @Operation(summary = "Sündmusesarja ühe toimumiskoha piletite koguste ja saadavuste toomine andmebaasist.",
            description = "Andmebaasist tuuakse sündmusesarja ühe toimumiskoha piletid ja saadavus eventTicketId abil")
    public EventTicketInfo getEventTicket(@RequestParam Integer eventTicketId) {
        return ticketService.getEventTicket(eventTicketId);
    }

    @GetMapping("/tickets")
    @Operation(summary = "Kõikide piletite koguste ja saadavuste toomine andmebaasist vastava sündmuse toimumiskoha kohta.",
            description = "Andmebaasist tuuakse kõik piletite kogused ja saadavus eventDetailId abil, kui nende staatus on aktiivne.")
    public List<EventTicketInfo> getEventTickets(@RequestParam Integer eventDetailId) {
        return ticketService.getEventTickets(eventDetailId);
    }

    @PutMapping("/ticket")
    @Operation(summary = "Olemasoleva pileti tüübi andmete muutmine.",
            description = "Andmebaasis kirjutatakse üle olemasoleva pileti tüübi andmed.")
    public void editEventTicket(@RequestBody TicketTypeInfo ticketTypeInfo) {
        ticketService.editEventTicket(ticketTypeInfo);
    }

}
