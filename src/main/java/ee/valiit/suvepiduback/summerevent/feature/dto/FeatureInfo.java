package ee.valiit.suvepiduback.summerevent.feature.dto;

import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.feature.Feature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Feature}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureInfo implements Serializable {
    private Integer featureId;
    private String featureName;
    private Boolean isAvailable = false;
}