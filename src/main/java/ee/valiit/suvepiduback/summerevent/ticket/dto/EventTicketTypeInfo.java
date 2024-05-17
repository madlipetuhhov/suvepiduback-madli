package ee.valiit.suvepiduback.summerevent.ticket.dto;

import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link TicketType}
 */
@Getter
@Setter
public class EventTicketTypeInfo implements Serializable {
    private Integer eventTicketTypeId;
    private String eventTicketTypeName;
}