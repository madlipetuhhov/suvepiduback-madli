package ee.valiit.suvepiduback.summerevent.tickettype;

import ee.valiit.suvepiduback.summerevent.tickettype.dto.TicketTypeInfo;
import ee.valiit.suvepiduback.summerevent.tickettype.dto.TicketTypeInfoExtended;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TicketTypeController {
    private final TicketTypeService ticketTypeService;

    @PostMapping("ticket-type")
    @Operation(summary = "Create a new ticket type by mainEventId.",
            description = "Creates a new ticket type in the database using the provided ticket type object (JSON payload) and mainEventId (query parameter).")
    public void addNewTicketTypes(@RequestParam Integer mainEventId, @RequestBody TicketTypeInfo ticketTypeInfo) {
        ticketTypeService.addNewTicketTypes(mainEventId, ticketTypeInfo);
    }

    @GetMapping("ticket-type")
    @Operation(summary = "Retrieve a ticket type by ticketTypeId.",
            description = "Retrieves a ticket type from the database based on the ticketTypeId (query parameter). Returns JSON containing ticket type info.")
    public TicketTypeInfoExtended getTicketType(@RequestParam Integer ticketTypeId) {
        return ticketTypeService.getTicketType(ticketTypeId);
    }

    @GetMapping("ticket-types")
    @Operation(summary = "Retrieve an array of ticket types by mainEventId.",
            description = "Retrieves an array of ticket types from the database based on the mainEventId (query parameter). Returns an array of ticket types.")
    public List<TicketTypeInfoExtended> getTicketTypes(@RequestParam Integer mainEventId) {
        return ticketTypeService.getTicketTypes(mainEventId);
    }

    @PutMapping("ticket-type")
    @Operation(summary = "Update an ticket type.",
            description = "Updates an existing ticket type in the database based on the provided ticket type object (JSON payload).")
    public void editTicketType(@RequestBody TicketTypeInfoExtended ticketTypeInfoExtended) {
        ticketTypeService.editTicketType(ticketTypeInfoExtended);
    }


}
