package ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.category;

import ee.valiit.suvepiduback.summerevent.category.dto.CategoryInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    @Mapping(source = "id",target = "categoryId")
    @Mapping(source = "name",target = "categoryName")
    CategoryInfo toCategoryInfo(Category category);

    List<CategoryInfo> toCategoryInfos(List<Category> categories);




}