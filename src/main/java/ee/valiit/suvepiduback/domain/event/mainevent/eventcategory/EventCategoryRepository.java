package ee.valiit.suvepiduback.domain.event.mainevent.eventcategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventCategoryRepository extends JpaRepository<EventCategory, Integer> {
    @Query("select e from EventCategory e where e.mainEvent.id = :mainEventId order by e.category.name")
    List<EventCategory> findEventCategoriesBy(Integer mainEventId);

    @Query("select e from EventCategory e where e.mainEvent.id = :mainEventId and e.category.id = :categoryId")
    Optional<EventCategory> findEventCategoryBy(Integer mainEventId, Integer categoryId);
}