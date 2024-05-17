package ee.valiit.suvepiduback.domain.account.user.role;

import ee.valiit.suvepiduback.summerevent.role.dto.RolesDropdownInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    @Mapping(source = "id", target = "roleId")
    @Mapping(source = "name", target = "roleName")
    RolesDropdownInfo toRolesDropdownInfo(Role role);

    List<RolesDropdownInfo> toRolesDropdownInfos(List<Role> roles);
}