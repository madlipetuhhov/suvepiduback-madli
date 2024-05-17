package ee.valiit.suvepiduback.domain.ticket.order;

import ee.valiit.suvepiduback.domain.account.user.User;
import ee.valiit.suvepiduback.domain.ticket.eventticket.EventTicket;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"order\"", schema = "suvepidu")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_ticket_id", nullable = false)
    private EventTicket eventTicket;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

}