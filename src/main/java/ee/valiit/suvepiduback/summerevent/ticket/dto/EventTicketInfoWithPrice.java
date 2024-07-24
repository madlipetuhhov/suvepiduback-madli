package ee.valiit.suvepiduback.summerevent.ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventTicketInfoWithPrice extends EventTicketInfo implements Serializable {
    private Integer ticketTypePrice;
}
