package ee.valiit.suvepiduback.summerevent.business;

import ee.valiit.suvepiduback.summerevent.business.dto.BusinessesDropdownInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class BusinessController {
    private final BusinessService businessService;
    @GetMapping("/businesses")
    @Operation(summary = "Ettevõtete valiku loomine vastava korraldaja konto kohta.",
            description = "Tagastab ettevõtete massiivi userId abil.")
    public List<BusinessesDropdownInfo> executeBusinessesDropdown(@RequestParam Integer userId) {
        return businessService.executeBusinessesDropdown(userId);
    }

}
