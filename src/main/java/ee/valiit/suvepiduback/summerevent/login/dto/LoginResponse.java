package ee.valiit.suvepiduback.summerevent.login.dto;

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
public class LoginResponse implements Serializable {
    private Integer userId;
    private String roleName;
}