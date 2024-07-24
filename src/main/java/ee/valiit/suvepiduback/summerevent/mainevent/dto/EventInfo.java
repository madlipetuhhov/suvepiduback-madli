package ee.valiit.suvepiduback.summerevent.mainevent.dto;

import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import ee.valiit.suvepiduback.summerevent.county.dto.CountyInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for {@link MainEvent}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventInfo implements Serializable {
    private String title;
    private String description;
    private List<EventDetail> eventDetails;
    private List<CountyInfo> counties;
    private List<Feature> features;
    private List<Category> categories;
    private List<Ticket> tickets;
    private String imageData;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EventDetail {
        private Integer eventDetailId;
        private String date;
        private String startTime;
        private String endTime;
        private String address;
        private BigDecimal longitude;
        private BigDecimal latitude;
    }

//    viidatud CountyInfo DTO-le, kas nii saab?
//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class County {
//        private Integer countyId;
//        private String countyName;
//    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Feature {
        private Integer featureId;
        private String featureName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Category {
        private Integer categoryId;
        private String categoryName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Ticket {
        private Integer eventTicketId;
        private String ticketTypeName;
        private Integer ticketTypePrice;
        private Integer total;
        private Integer available;
    }



//    see mis alguses tegin:
//    private String title;
//    private String description;
//    private Integer eventDetailId;
//    private String date;
//    private String startTime;
//    private String endTime;
//    private String address;
//    private String countyName;
//    private BigDecimal longitude;
//    private BigDecimal latitude;
//    private Integer featureId;
//    private String featureName;
//    private Integer categoryId;
//    private String categoryName;
//    private String ticketTypeName;
//    private Integer ticketTypePrice;
//    private Integer total;
//    private Integer available;
//    private String imageData;
}