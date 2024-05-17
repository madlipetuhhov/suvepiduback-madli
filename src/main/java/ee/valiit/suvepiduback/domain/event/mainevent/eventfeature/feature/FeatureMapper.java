package ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.feature;

import ee.valiit.suvepiduback.summerevent.feature.dto.FeatureInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FeatureMapper {
    @Mapping(source = "id",target = "featureId")
    @Mapping(source = "name",target = "featureName")
    FeatureInfo toFeatureInfo(Feature feature);

    List<FeatureInfo> toFeatureInfos(List<Feature> features);
}