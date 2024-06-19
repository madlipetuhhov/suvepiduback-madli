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
    @Operation(summary = "Adding features to the event.",
            description = "Features are added to the database for the event using mainEventId.")
    public void updateFeatures(@RequestParam Integer mainEventId, @RequestBody List<FeatureInfo> featureInfos) {
        eventFeatureService.updateFeatures(mainEventId, featureInfos);
    }

    @GetMapping("/event/features")
    @Operation(summary = "Retrieving all selected features from the database for the event.",
            description = "All features of the event are fetched from the database using mainEventId to display in a table.")
    public List<EventFeatureInfo> getEventFeaturesForView(@RequestParam Integer mainEventId) {
        return eventFeatureService.getEventFeaturesForView(mainEventId);
    }

    @GetMapping("/event/features-modal")
    @Operation(summary = "Retrieving all selected features from the database for the event.",
            description = "All selected features of the event are fetched from the database using mainEventId to display in the modal.")
    public List<FeatureInfo> getEventFeaturesForModal(@RequestParam Integer mainEventId) {
        return eventFeatureService.getEventFeaturesForModal(mainEventId);
    }

    @PutMapping("/event/features-modal")
    @Operation(summary = "Modify existing features data.",
            description = "In the database, the features data of the existing event is overwritten using mainEventId.")
    public void editEventFeatures(@RequestParam Integer mainEventId, @RequestBody List<FeatureInfo> featureInfos) {
        eventFeatureService.editEventFeatures(mainEventId, featureInfos);
    }

}
