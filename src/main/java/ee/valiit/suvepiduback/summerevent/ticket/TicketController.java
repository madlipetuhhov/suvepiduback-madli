package ee.valiit.suvepiduback.summerevent.ticket;

import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketInfo;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketRequest;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketTypeInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController

public class TicketController {
    private final TicketService ticketService;

    @PostMapping("ticket")
    @Operation(summary = "Sündmuse toimumiskohale piletite koguse ja saadavuse lisamine.",
            description = "Andmebaasi lisatakse sündmuse toimumiskohale juurde piletikogused ja saadavused (eventDetailId abil).")
    public void addTickets(@RequestParam Integer eventDetailId, @RequestBody EventTicketRequest eventTicketInfo) {
        ticketService.addTickets(eventDetailId, eventTicketInfo);
    }

    @GetMapping("tickets")
    @Operation(summary = "Kõikide piletite koguste ja saadavuste toomine andmebaasist vastava sünmduse toimumiskoha kohta.",
            description = "Andmebaasist tuuakse kõik piletite kogused ja saadavus eventDetailId abil, kui nende staatus on aktiivne.")
    public List<EventTicketInfo> getEventTickets(@RequestParam Integer eventDetailId) {
        return ticketService.getEventTickets(eventDetailId);
    }

}
