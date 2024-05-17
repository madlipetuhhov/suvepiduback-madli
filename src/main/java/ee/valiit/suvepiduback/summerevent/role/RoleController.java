package ee.valiit.suvepiduback.summerevent.role;

import ee.valiit.suvepiduback.summerevent.role.dto.RolesDropdownInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/roles")
    @Operation(summary = "Rollide valiku loomine. Tagastab roleId.",
            description = "Süsteemist otsitakse roleId abil rollid.")
    public List<RolesDropdownInfo> executeRolesDropdown() {
        return roleService.executeRolesDropdown();
    }
}
