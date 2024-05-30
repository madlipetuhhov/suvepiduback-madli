package ee.valiit.suvepiduback.summerevent.eventdetail.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link ee.valiit.suvepiduback.domain.event.eventdetail.EventDetail}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDetailInfo implements Serializable {
    @NotNull
    private Integer countyId;
    @NotNull
    private String date;
    @NotNull
    private String startTime;
    @NotNull
    private String endTime;
    @NotNull
    @Size(max = 50)
    private String address;
    @NotNull
    private BigDecimal longitude;
    @NotNull
    private BigDecimal latitude;
}