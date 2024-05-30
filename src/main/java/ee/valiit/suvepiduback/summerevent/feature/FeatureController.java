package ee.valiit.suvepiduback.summerevent.feature;

import ee.valiit.suvepiduback.summerevent.feature.dto.FeatureInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class FeatureController {
    private final FeatureService featureService;

    @GetMapping("/features")
    @Operation(summary = "Võimaluste valiku loomine.",
            description = "Tagastab võimaluste massiivi.")
    public List<FeatureInfo> executeFeaturesList() {
        return featureService.executeFeaturesList();
    }

}
