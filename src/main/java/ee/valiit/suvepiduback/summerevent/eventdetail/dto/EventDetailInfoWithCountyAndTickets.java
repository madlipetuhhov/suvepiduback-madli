package ee.valiit.suvepiduback.summerevent.eventdetail.dto;

import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketInfoWithPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDetailInfoWithCountyAndTickets extends EventDetailInfoWithCounty implements Serializable {
    private List<EventTicketInfoWithPrice> tickets;
}