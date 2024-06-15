package ee.valiit.suvepiduback.summerevent.ticket.dto;

import ee.valiit.suvepiduback.domain.ticket.eventticket.EventTicket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link EventTicket}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventTicketRequest implements Serializable {
    private Integer ticketTypeId;
    private Integer total;
}