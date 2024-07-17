package ee.valiit.suvepiduback.summerevent.business.dto;

import ee.valiit.suvepiduback.domain.account.business.Business;
import ee.valiit.suvepiduback.summerevent.account.dto.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Business}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessInfo extends UserInfo implements Serializable {
    private String companyName;
    private String registryCode;
    private String vatNumber;
    private String phone;
    private String email;
}