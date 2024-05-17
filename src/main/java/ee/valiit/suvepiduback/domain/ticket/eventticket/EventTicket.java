package ee.valiit.suvepiduback.domain.ticket.eventticket;

import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetail;
import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "event_ticket", schema = "suvepidu")
public class EventTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_detail_id", nullable = false)
    private EventDetail eventDetail;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_type_id", nullable = false)
    private TicketType ticketType;

    @NotNull
    @Column(name = "total", nullable = false)
    private Integer total;

    @NotNull
    @Column(name = "available", nullable = false)
    private Integer available;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

}