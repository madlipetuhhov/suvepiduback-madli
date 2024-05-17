package ee.valiit.suvepiduback.summerevent.mainevent.dto;

import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link MainEvent}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainEventInfoExtended extends MainEventInfo implements Serializable {
    private Integer mainEventId;
}