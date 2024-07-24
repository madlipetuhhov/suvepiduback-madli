package ee.valiit.suvepiduback.summerevent.mainevent.dto;

import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import ee.valiit.suvepiduback.summerevent.category.dto.CategoryInfo;
import ee.valiit.suvepiduback.summerevent.eventdetail.dto.EventDetailInfoWithCountyAndTickets;
import ee.valiit.suvepiduback.summerevent.feature.dto.FeatureInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link MainEvent}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventInfo implements Serializable {
    private String title;
    private String description;
    private List<FeatureInfo> features;
    private List<CategoryInfo> categories;
    private List<EventDetailInfoWithCountyAndTickets> eventDetails;
    private String imageData;
}