package ee.valiit.suvepiduback.domain.ticket.tickettype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketTypeRepository extends JpaRepository<TicketType, Integer> {

    @Query("select t from TicketType t where t.mainEvent.id = :mainEventId order by t.price")
    List<TicketType> findTicketTypesBy(Integer mainEventId);


}