package ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.feature;

import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeatureRepository extends JpaRepository<Feature, Integer> {

//    List<Feature> findFeatureNamesBy(List<Integer> eventFeatureIds);


    @Query("select f from Feature f where f.id = :eventFeatureIds order by f.name")
    List<Feature> findNamesBy(List<Integer> eventFeatureIds);
}