package ee.valiit.suvepiduback.summerevent.mainevent.dto;

import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import ee.valiit.suvepiduback.summerevent.eventcategory.dto.EventCategoryInfo;
import ee.valiit.suvepiduback.summerevent.eventdetail.dto.EventDetailInfoWithCounty;
import ee.valiit.suvepiduback.summerevent.eventdetail.dto.EventDetailInfoWithCountyAndTickets;
import ee.valiit.suvepiduback.summerevent.eventfeature.dto.EventFeatureInfo;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketInfoWithPrice;
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
//    private List<EventDetailInfoWithCountyAndTickets> eventDetails;
    private List<EventDetailInfoWithCounty> eventDetails;
    private List<EventTicketInfoWithPrice> tickets;
    private String imageData;
}