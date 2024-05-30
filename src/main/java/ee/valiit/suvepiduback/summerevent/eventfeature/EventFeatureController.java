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

//    post meetod ei ole frondis kasutusel, put meetodi abil toimub muutmine
    @PostMapping("/event/features")
    @Operation(summary = "Sündmusele võimaluste lisamine.",
            description = "Andmebaasi lisatakse sündmusele juurde võimalused mainEventId abil.")
    public void updateFeatures(@RequestParam Integer mainEventId, @RequestBody List<FeatureInfo> featureInfos) {
        eventFeatureService.updateFeatures(mainEventId,featureInfos);
    }

    @GetMapping("/event/features")
    @Operation(summary = "Kõikide valitud võimaluste andmebaasist toomine vastava sündmuse kohta tabelis kuvamiseks.",
            description = "Andmebaasist tuuakse vastava sündmuse kõik võimalused mainEventId abil.")
    public List<EventFeatureInfo> getEventFeaturesForView(@RequestParam Integer mainEventId) {
        return eventFeatureService.getEventFeaturesForView(mainEventId);
    }

    @GetMapping("/event/features-modal")
    @Operation(summary = "Kõikide valitud võimaluste andmebaasist toomine vastava sündmuse kohta modalis kuvamiseks.",
            description = "Andmebaasist tuuakse vastava sündmuse kõik võimalused mainEventId abil.")
    public List<FeatureInfo> getEventFeaturesForModal(@RequestParam Integer mainEventId) {
        return eventFeatureService.getEventFeaturesForModal(mainEventId);
    }

    @PutMapping("/event/features-modal")
    @Operation(summary = "Olemasolevate võimaluste andmete muutmine.",
            description = "Andmebaasis kirjutatakse üle olemasoleva sündmuse võimaluste andmed mainEventId abil.")
    public void editEventFeatures(@RequestParam Integer mainEventId, @RequestBody List<FeatureInfo> featureInfos) {
        eventFeatureService.editEventFeatures(mainEventId, featureInfos);
    }

}
