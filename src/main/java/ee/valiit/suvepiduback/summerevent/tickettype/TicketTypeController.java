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
    @Operation(summary = "Uuele sündmusele piletitüübi ja selle hinna lisamine.",
            description = "Süsteemi lisatakse sündmusele juurde piletitüübid ja nende hinnad mainEventId abil.")
    public void addNewTicketTypes(@RequestParam Integer mainEventId, @RequestBody TicketTypeInfo ticketTypeInfo) {
//        siin võib-olla ei pea midagi tagastama, kui siis ticketTypeId, aga mitte mainEventId
        ticketTypeService.addNewTicketTypes(mainEventId, ticketTypeInfo);
    }

    @GetMapping("ticket-type")
    @Operation(summary = "Ühe pileti tüübi toomine andmebaasist.",
            description = "Andmebaasist tuuakse üks pileti tüüp ticketTypeId abil.")
    public TicketTypeInfoExtended getTicketType(@RequestParam Integer ticketTypeId) {
//        tagastada rohkema id-dega DTO, sest siis ma ei pea frondis eraldi külge panema id, vaid kohe olemas
        return ticketTypeService.getTicketType(ticketTypeId);
    }

    @GetMapping("ticket-types")
    @Operation(summary = "Kõikide pileti tüüpide andmebaasist toomine vastava sündmuse kohta.",
            description = "Andmebaasist tuuakse vastava sündmuse kõik piletitüübid mainEventId abil.")
    public List<TicketTypeInfoExtended> getTicketTypes(@RequestParam Integer mainEventId) {
        return ticketTypeService.getTicketTypes(mainEventId);
    }

    @PutMapping("ticket-type")
    @Operation(summary = "Olemasoleva pileti tüübi andmete muutmine.",
            description = "Andmebaasis kirjutatakse üle olemasoleva pileti tüübi andmed.")
    public void editTicketType(@RequestBody TicketTypeInfoExtended ticketTypeInfoExtended) {
        ticketTypeService.editTicketType(ticketTypeInfoExtended);
    }


}
