package ee.valiit.suvepiduback.summerevent.tickettype.dto;

import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link TicketType}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeInfo implements Serializable {
    private String ticketTypeName;
    private Integer ticketTypePrice;
}