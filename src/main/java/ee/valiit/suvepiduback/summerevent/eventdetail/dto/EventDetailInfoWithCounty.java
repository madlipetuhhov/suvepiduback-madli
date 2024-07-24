package ee.valiit.suvepiduback.summerevent.eventdetail.dto;

import ee.valiit.suvepiduback.domain.event.eventdetail.county.County;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link County}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDetailInfoWithCounty extends EventDetailInfo implements Serializable {
    private String countyName;
    private Integer eventDetailId;
}