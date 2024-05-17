package ee.valiit.suvepiduback.summerevent.category;

import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.category.Category;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.category.CategoryMapper;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.category.CategoryRepository;
import ee.valiit.suvepiduback.summerevent.category.dto.CategoryInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryInfo> executeCategoriesList() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toCategoryInfos(categories);
    }
}
