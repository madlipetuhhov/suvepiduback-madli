package ee.valiit.suvepiduback.summerevent.eventcategory.dto;

import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.EventCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link EventCategory}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventCategoryInfo implements Serializable {
    private Integer categoryId;
    private Integer mainEventId;
    private String categoryName;
    private Boolean isAvailable;
}