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
    @Operation(summary = "Uuele sündmusesarjale detailide lisamine. Tagastab eventDetailId. ",
            description = "Süsteemi lisatakse sündmusele juurde detailid eventDetailId abil.")
    public Integer addEventDetail(@RequestParam Integer mainEventId, @RequestBody EventDetailInfo eventDetailInfo) {
        return eventDetailService.addEventDetail(mainEventId, eventDetailInfo);

    }

    @GetMapping("/event/detail")
    @Operation(summary = "Sündmuse detailide toomine andmebaasist vastavalt mainEventId-le",
            description = "Andmebaasist tuuakse vastava ürituse sarja detailid eventDetailId abil")
    public EventDetailInfo getEventDetail(@RequestParam Integer eventDetailId) {
        return eventDetailService.getEventDetail(eventDetailId);

    }

    @GetMapping("/event/details")
    @Operation(summary = "Sündmuste listi toomine andmebaasist vastavalt mainEventId-le",
            description = "Andmebaasist tuuakse vastava ürituse sarja kõik toimumiskohad (detailid) mainEventId abil")
    public List<EventDetailInfoExtended> getEventDetails(@RequestParam Integer mainEventId) {
        return eventDetailService.getEventDetails(mainEventId);

    }

    @PutMapping("/event/detail")
    @Operation(summary = "Olemasoleva sündmuse detailide andmete muutmine mainEventId abil.",
            description = "Andmebaasis kirjutatakse üle olemasoleva sündmuse detailide andmed.")
    public void editEventDetail(@RequestParam Integer eventDetailId, @RequestBody EventDetailInfo eventDetailInfo) {
        eventDetailService.editEventDetail(eventDetailId, eventDetailInfo);
    }
}
