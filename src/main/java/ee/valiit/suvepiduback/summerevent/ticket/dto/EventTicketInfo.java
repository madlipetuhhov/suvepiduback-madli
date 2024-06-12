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
public class EventTicketInfo implements Serializable {
    private Integer eventTicketId;

    private String ticketTypeName;

    private Integer total;

    private Integer available;

    private String status;
}