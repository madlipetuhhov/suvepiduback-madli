package ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.feature;

import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeatureRepository extends JpaRepository<Feature, Integer> {

    List<Feature> findFeatureNamesBy(List<Integer> eventFeatureIds);
}