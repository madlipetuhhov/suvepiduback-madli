package ee.valiit.suvepiduback.summerevent.mainevent.dto;

import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import ee.valiit.suvepiduback.summerevent.eventcategory.dto.EventCategoryInfo;
import ee.valiit.suvepiduback.summerevent.eventdetail.dto.EventDetailInfoWithCountyAndTickets;
import ee.valiit.suvepiduback.summerevent.eventfeature.dto.EventFeatureInfo;
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
    private List<EventFeatureInfo> features;
    private List<EventCategoryInfo> categories;
    private List<EventDetailInfoWithCountyAndTickets> eventDetails;
    private String imageData;
}