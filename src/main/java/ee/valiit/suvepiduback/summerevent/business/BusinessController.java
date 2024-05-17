package ee.valiit.suvepiduback.summerevent.business;

import ee.valiit.suvepiduback.summerevent.business.dto.BusinessesDropdownInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class BusinessController {
    private final BusinessService businessService;
    @GetMapping("/businesses")
    @Operation(summary = "Ettevõtete (companyName) valiku loomine. Tagastab businessId.",
            description = "Süsteemist otsitakse businessId abil ettevõtted (companyName).")
    public List<BusinessesDropdownInfo> executeBusinessesDropdown() {
        return businessService.executeBusinessesDropdown();
    }

}
