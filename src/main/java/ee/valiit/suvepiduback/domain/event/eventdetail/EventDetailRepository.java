package ee.valiit.suvepiduback.domain.event.eventdetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EventDetailRepository extends JpaRepository<EventDetail, Integer> {



    @Query("select e from EventDetail e where e.mainEvent.id = :mainEventId")
    List<EventDetail> findEventDetailsBy(Integer mainEventId);
}

