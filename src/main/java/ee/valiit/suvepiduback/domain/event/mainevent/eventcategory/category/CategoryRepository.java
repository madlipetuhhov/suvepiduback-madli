package ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findCategoryNamesBy(List<Integer> eventCategoryIds);
}