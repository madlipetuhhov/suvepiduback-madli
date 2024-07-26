package ee.valiit.suvepiduback.domain.event.mainevent.eventfeature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventFeatureRepository extends JpaRepository<EventFeature, Integer> {
    @Query("select e from EventFeature e where e.mainEvent.id = :mainEventId order by e.feature.name")
    List<EventFeature> findEventFeaturesBy(Integer mainEventId);

    @Query("select e from EventFeature e where e.mainEvent.id = :mainEventId and e.feature.id = :featureId")
    Optional<EventFeature> findEventFeatureBy(Integer mainEventId, Integer featureId);
}
