package ee.valiit.suvepiduback.summerevent.mainevent.dto;

import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link MainEvent}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventInfo implements Serializable {
    private String title;
    private String description;
    private String imageData;
    private Integer featureId;
    private String featureName;
    private Integer categoryId;
    private String categoryName;
    private Integer eventDetailId;
    private String date;
    private String startTime;
    private String endTime;
    private String address;
    private String countyName;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String ticketTypeName;
    private Integer ticketTypePrice;
    private Integer total;
    private Integer available;
}