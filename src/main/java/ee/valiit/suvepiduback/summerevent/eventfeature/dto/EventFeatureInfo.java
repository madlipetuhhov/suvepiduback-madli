package ee.valiit.suvepiduback.summerevent.eventfeature.dto;

import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.EventFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link EventFeature}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventFeatureInfo implements Serializable {
    private Integer featureId;
    private Integer mainEventId;
    private String featureName;
    private Boolean isAvailable;
}