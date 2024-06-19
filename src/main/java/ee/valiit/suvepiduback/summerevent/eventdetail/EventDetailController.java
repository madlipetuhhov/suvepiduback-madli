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
    @Operation(summary = "Create a new event detail by mainEventId.",
            description = "Creates a new event detail in the database using the provided event detail object (JSON payload) and mainEventId (query parameter). Returns mainEventId.")
    public Integer addEventDetail(@RequestParam Integer mainEventId, @RequestBody EventDetailInfo eventDetailInfo) {
        return eventDetailService.addEventDetail(mainEventId, eventDetailInfo);
    }

    @GetMapping("/event/detail")
    @Operation(summary = "Retrieve an event detail by mainEventId.",
            description = "Retrieves an event detail from the database based on the eventDetailId (query parameter). Returns JSON containing event detail info.")
    public EventDetailInfo getEventDetail(@RequestParam Integer eventDetailId) {
        return eventDetailService.getEventDetail(eventDetailId);
    }

    @GetMapping("/event/details")
    @Operation(summary = "Retrieve an array of event details by mainEventId.",
            description = "Retrieves an array of event details from the database based on the eventDetailId (query parameter). Returns an array of event details.")
    public List<EventDetailInfoExtended> getEventDetails(@RequestParam Integer mainEventId) {
        return eventDetailService.getEventDetails(mainEventId);
    }

    @PutMapping("/event/detail")
    @Operation(summary = "Update event details.",
            description = "Updates event details in the database based on the eventDetailId (query parameter) and provided event detail object (JSON payload).")
    public void editEventDetail(@RequestParam Integer eventDetailId, @RequestBody EventDetailInfo eventDetailInfo) {
        eventDetailService.editEventDetail(eventDetailId, eventDetailInfo);
    }
}
