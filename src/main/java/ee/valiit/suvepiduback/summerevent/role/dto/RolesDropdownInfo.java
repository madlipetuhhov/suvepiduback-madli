package ee.valiit.suvepiduback.summerevent.role.dto;

import ee.valiit.suvepiduback.domain.account.user.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Role}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolesDropdownInfo implements Serializable {
    private Integer roleId;
    private String roleName;
}