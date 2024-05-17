package ee.valiit.suvepiduback.domain.account.user;

import ee.valiit.suvepiduback.summerevent.Status;
import ee.valiit.suvepiduback.summerevent.login.dto.LoginResponse;
import ee.valiit.suvepiduback.summerevent.account.dto.UserInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "roleId", target = "role.id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(constant = Status.ACTIVE, target = "status")
    User toUser(UserInfo userInfo);

}