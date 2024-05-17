package ee.valiit.suvepiduback.summerevent.account.dto;

import ee.valiit.suvepiduback.domain.account.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    private Integer roleId;
    private String username;
    private String password;
}