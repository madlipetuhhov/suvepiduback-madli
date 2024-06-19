package ee.valiit.suvepiduback.summerevent.county;

import ee.valiit.suvepiduback.summerevent.county.dto.CountyInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class CountyController {

    private final CountyService countyService;

    @GetMapping("/counties")
    @Operation(summary = "Creating the counties option for the dropdown menu.",
            description = "Returns an array of counties.")
    public List<CountyInfo> executeCountyList() {
        return countyService.executeCountyList();
    }
}
