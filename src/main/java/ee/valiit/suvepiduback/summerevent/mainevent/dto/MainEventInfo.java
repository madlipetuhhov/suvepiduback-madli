package ee.valiit.suvepiduback.summerevent.mainevent.dto;

import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link MainEvent}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainEventInfo implements Serializable {
    private String title;
    private String description;
    private String imageData;
}