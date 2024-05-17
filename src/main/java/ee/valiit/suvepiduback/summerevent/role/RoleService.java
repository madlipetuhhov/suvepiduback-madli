package ee.valiit.suvepiduback.summerevent.role;

import ee.valiit.suvepiduback.domain.account.user.role.Role;
import ee.valiit.suvepiduback.domain.account.user.role.RoleMapper;
import ee.valiit.suvepiduback.domain.account.user.role.RoleRepository;
import ee.valiit.suvepiduback.summerevent.role.dto.RolesDropdownInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    public List<RolesDropdownInfo> executeRolesDropdown() {
        List<Role> roles = roleRepository.findAll();
        return roleMapper.toRolesDropdownInfos(roles);
    }

}
