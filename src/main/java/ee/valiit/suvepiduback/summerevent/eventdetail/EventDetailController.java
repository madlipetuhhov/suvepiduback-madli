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
    @Operation(summary = "Adding event location information to a new event series.",
            description = "Adding event location information to the event series using mainEventId. Returns eventDetailId.")
    public Integer addEventDetail(@RequestParam Integer mainEventId, @RequestBody EventDetailInfo eventDetailInfo) {
        return eventDetailService.addEventDetail(mainEventId, eventDetailInfo);
    }

    @GetMapping("/event/detail")
    @Operation(summary = "Retrieving one location of the event series from the database.",
            description = "The information of one location of the event series is retrieved from the database using eventDetailId.")
    public EventDetailInfo getEventDetail(@RequestParam Integer eventDetailId) {
        return eventDetailService.getEventDetail(eventDetailId);
    }

    @GetMapping("/event/details")
    @Operation(summary = "Retrieving all locations of a series of events from the database.",
            description = "All event locations of the corresponding event series are fetched from the database using mainEventId.")
    public List<EventDetailInfoExtended> getEventDetails(@RequestParam Integer mainEventId) {
        return eventDetailService.getEventDetails(mainEventId);
    }

    @PutMapping("/event/detail")
    @Operation(summary = "Change event location data for an existing event series.",
            description = "In the database, the event location data of the existing event series is overwritten using eventDetailId.")
    public void editEventDetail(@RequestParam Integer eventDetailId, @RequestBody EventDetailInfo eventDetailInfo) {
        eventDetailService.editEventDetail(eventDetailId, eventDetailInfo);
    }
}
