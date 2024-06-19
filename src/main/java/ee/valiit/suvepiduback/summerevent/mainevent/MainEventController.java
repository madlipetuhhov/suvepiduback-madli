package ee.valiit.suvepiduback.summerevent.mainevent;

import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfo;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfoExtended;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class MainEventController {
    private final MainEventService mainEventService;

    @PostMapping("/event/main")
    @Operation(summary = "Create a new event by businessId.",
            description = "Creates a new event in the database using the provided event object (JSON payload) and businessId (query parameter). Returns mainEventId.")
    public Integer addNewMainEvent(@RequestParam Integer businessId, @RequestBody MainEventInfo mainEventInfo) {
        return mainEventService.addNewMainEvent(businessId, mainEventInfo);
    }

    @GetMapping("/event/main")
    @Operation(summary = "Retrieve an event by mainEventId.",
            description = "Retrieves an event from the database based on the mainEventId (query parameter) and checks for active status. Returns JSON containing event info.")
    public MainEventInfoExtended getMainEvent(@RequestParam Integer mainEventId) {
        return mainEventService.getMainEvent(mainEventId);
    }

    @GetMapping("/events/main")
    @Operation(summary = "Retrieve an array of events by businessId.",
            description = "Retrieves an array of events from the database based on the businessId (query parameter) and checks for active status. Returns an array of events.")
    public List<MainEventInfoExtended> getMainEvents(@RequestParam Integer businessId) {
        return mainEventService.getMainEvents(businessId);
    }

    @GetMapping("/event/name")
    @Operation(summary = "Retrieve an event title by eventDetailId.",
            description = "Retrieves an event title from the database based on the eventDetailId (query parameter). Returns event title as String.")
    public String getMainEventName(@RequestParam Integer eventDetailId) {
        return mainEventService.getMainEventName(eventDetailId);
    }

    @PutMapping("/event/main")
    @Operation(summary = "Update an event.",
            description = "Updates an existing event in the database based on the provided event object (JSON payload).")
    public void editMainEvent(@RequestBody MainEventInfoExtended mainEventInfoExtended) {
        mainEventService.editMainEvent(mainEventInfoExtended);
    }

    @DeleteMapping("/event/main")
    @Operation(summary = "Delete an event by mainEventId.",
            description = "The event is not deleted from the database but deactivated based on the mainEventId (query parameter). Returns mainEventId as Integer.")
    public Integer removeMainEvent(@RequestParam Integer mainEventId) {
        return mainEventService.removeMainEvent(mainEventId);
    }
}
