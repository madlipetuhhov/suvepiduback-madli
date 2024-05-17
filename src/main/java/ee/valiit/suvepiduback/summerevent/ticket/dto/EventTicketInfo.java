package ee.valiit.suvepiduback.summerevent.ticket.dto;

import ee.valiit.suvepiduback.domain.ticket.eventticket.EventTicket;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private String ticketTypeName;
    @NotNull
    private Integer total;
    @NotNull
    private Integer available;
    @NotNull
    private String status;
}