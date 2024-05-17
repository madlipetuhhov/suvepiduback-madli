package ee.valiit.suvepiduback.domain.event.eventdetail.county;

import ee.valiit.suvepiduback.summerevent.county.dto.CountyInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountyMapper {

    @Mapping(source = "id", target = "countyId")
    @Mapping(source = "county", target = "countyName")
    CountyInfo toCountyInfo(County county);

    List<CountyInfo> toCountyInfos(List<County> counties);

}