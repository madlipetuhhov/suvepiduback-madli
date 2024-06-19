package ee.valiit.suvepiduback.summerevent.eventfeature;

import ee.valiit.suvepiduback.summerevent.eventfeature.dto.EventFeatureInfo;
import ee.valiit.suvepiduback.summerevent.feature.dto.FeatureInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class EventFeatureController {
    private final EventFeatureService eventFeatureService;

    @PostMapping("/event/features")
    @Operation(summary = "Create features to the event by mainEventId.",
            description = "Creates features in the database for the event using mainEventId (query parameter) and an array of features (JSON payload).")
    public void updateFeatures(@RequestParam Integer mainEventId, @RequestBody List<FeatureInfo> featureInfos) {
        eventFeatureService.updateFeatures(mainEventId, featureInfos);
    }

    @GetMapping("/event/features")
    @Operation(summary = "Retrieve an array of selected features by mainEventId.",
            description = "Retrieves an array of selected features of the event from the database using mainEventId (query parameter). Returns an array of selected features.")
    public List<EventFeatureInfo> getEventFeaturesForView(@RequestParam Integer mainEventId) {
        return eventFeatureService.getEventFeaturesForView(mainEventId);
    }

    @GetMapping("/event/features-modal")
    @Operation(summary = "Retrieve an array of selected features by mainEventId for modal.",
            description = "Retrieves an array of selected features of the event from the database using mainEventId (query parameter). Returns an array of selected features.")
    public List<FeatureInfo> getEventFeaturesForModal(@RequestParam Integer mainEventId) {
        return eventFeatureService.getEventFeaturesForModal(mainEventId);
    }

    @PutMapping("/event/features-modal")
    @Operation(summary = "Update event features.",
            description = "Updates an existing event features in the database using mainEventId (query parameter) and an array of features (JSON payload).")
    public void editEventFeatures(@RequestParam Integer mainEventId, @RequestBody List<FeatureInfo> featureInfos) {
        eventFeatureService.editEventFeatures(mainEventId, featureInfos);
    }

}
