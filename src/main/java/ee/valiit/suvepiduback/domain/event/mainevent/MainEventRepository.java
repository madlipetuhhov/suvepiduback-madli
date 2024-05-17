package ee.valiit.suvepiduback.domain.event.mainevent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MainEventRepository extends JpaRepository<MainEvent, Integer> {

    @Query("select m from MainEvent m where m.id = :mainEventId and m.status = :status order by m.title")
    MainEvent findMainEventBy(Integer mainEventId, String status);

    @Query("select m from MainEvent m where m.business.id = :businessId and m.status = :status order by m.title")
    List<MainEvent> findMainEventsBy(Integer businessId, String status);


}