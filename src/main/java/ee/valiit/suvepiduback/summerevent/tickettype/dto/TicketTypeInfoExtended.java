package ee.valiit.suvepiduback.summerevent.tickettype.dto;

import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link TicketType}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeInfoExtended extends TicketTypeInfo implements Serializable {
    private Integer ticketTypeId;
    private Integer mainEventId;

}