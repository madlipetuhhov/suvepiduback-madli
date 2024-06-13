package ee.valiit.suvepiduback.domain.ticket.eventticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventTicketRepository extends JpaRepository<EventTicket, Integer> {


    @Query("""
            select e from EventTicket e
            where e.eventDetail.id = :eventDetailId and e.status = :status
            order by e.ticketType.price DESC""")
    List<EventTicket> findEventTicketsBy(Integer eventDetailId, String status);
}