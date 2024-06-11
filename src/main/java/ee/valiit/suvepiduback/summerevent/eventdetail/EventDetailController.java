package ee.valiit.suvepiduback.summerevent.eventdetail;

import ee.valiit.suvepiduback.summerevent.eventdetail.dto.EventDetailInfo;
import ee.valiit.suvepiduback.summerevent.eventdetail.dto.EventDetailInfoExtended;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class EventDetailController {

    private final EventDetailService eventDetailService;

    @PostMapping("/event/detail")
    @Operation(summary = "Uuele sündmusesarjale toimumiskohta info lisamine.",
            description = "Lisatakse sündmusesarjale juurde toimumiskoha info mainEventId abil. Tagastab eventDetailId.")
    public Integer addEventDetail(@RequestParam Integer mainEventId, @RequestBody EventDetailInfo eventDetailInfo) {
        return eventDetailService.addEventDetail(mainEventId, eventDetailInfo);
    }

    @GetMapping("/event/detail")
    @Operation(summary = "Sündmusesarja ühe toimumiskoha toomine andmebaasist.",
            description = "Andmebaasist tuuakse sündmusesarja ühe toimumiskoha info eventDetailId abil")
    public EventDetailInfo getEventDetail(@RequestParam Integer eventDetailId) {
        return eventDetailService.getEventDetail(eventDetailId);
    }

    @GetMapping("/event/details")
    @Operation(summary = "Sündmustesarja kõikide toimumiskohtade toomine andmebaasist.",
            description = "Andmebaasist tuuakse vastava sündmusesarja kõik toimumiskohad mainEventId abil")
    public List<EventDetailInfoExtended> getEventDetails(@RequestParam Integer mainEventId) {
        return eventDetailService.getEventDetails(mainEventId);
    }

    @PutMapping("/event/detail")
    @Operation(summary = "Olemasoleva sündmusesarja toimumiskoha andmete muutmine.",
            description = "Andmebaasis kirjutatakse üle olemasoleva sündmusesarja toimumiskoha andmed eventDetailId abil.")
    public void editEventDetail(@RequestParam Integer eventDetailId, @RequestBody EventDetailInfo eventDetailInfo) {
        eventDetailService.editEventDetail(eventDetailId, eventDetailInfo);
    }
}
