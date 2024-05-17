package ee.valiit.suvepiduback.summerevent.category.dto;

import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Category}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryInfo implements Serializable {
    private Integer categoryId;
    private String categoryName;
    private Boolean isAvailable = false;
}