package ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


//    List<Category> findCategoryNamesBy(List<Integer> eventCategoryIds);

    @Query("select c from Category c where c.id in :eventCategoryIds order by c.name")
    List<Category> findNamesBy(List<Integer> eventCategoryIds);
}