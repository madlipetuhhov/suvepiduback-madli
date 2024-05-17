package ee.valiit.suvepiduback.domain.event.mainevent.eventfeature;

import ee.valiit.suvepiduback.summerevent.eventfeature.dto.EventFeatureInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventFeatureMapper {

    @Mapping(source = "mainEvent.id", target = "mainEventId")
    @Mapping(source = "feature.id", target = "featureId")
    @Mapping(source = "feature.name", target = "featureName")
    @Mapping(constant = "true", target = "isAvailable")
    EventFeatureInfo toEventFeatureInfo(EventFeature eventFeature);

    List<EventFeatureInfo> toEventFeatureInfos(List<EventFeature> eventFeatures);

}