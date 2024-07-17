package ee.valiit.suvepiduback.summerevent.business.dto;

import ee.valiit.suvepiduback.domain.account.business.Business;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class BusinessContactsInfo implements Serializable {
    @NotNull
    @Size(max = 50)
    private String companyName;
    @NotNull
    @Size(max = 50)
    private String phone;
    @NotNull
    @Size(max = 50)
    private String email;
}