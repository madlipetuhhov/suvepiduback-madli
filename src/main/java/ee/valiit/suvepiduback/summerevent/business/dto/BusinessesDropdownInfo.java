package ee.valiit.suvepiduback.summerevent.business.dto;

import ee.valiit.suvepiduback.domain.account.business.Business;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Business}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessesDropdownInfo implements Serializable {
    private Integer businessId;
    private String companyName;
}