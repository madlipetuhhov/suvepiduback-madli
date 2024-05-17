package ee.valiit.suvepiduback.domain.ticket.eventticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventTicketRepository extends JpaRepository<EventTicket, Integer> {


    @Query("select e from EventTicket e where e.eventDetail.id = :eventDetailId order by e.ticketType.name")
    List<EventTicket> findEventTicketsBy( Integer eventDetailId);
}