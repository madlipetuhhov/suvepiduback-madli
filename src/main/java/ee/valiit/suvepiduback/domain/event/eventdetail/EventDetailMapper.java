package ee.valiit.suvepiduback.domain.event.eventdetail;

import ee.valiit.suvepiduback.summerevent.eventdetail.dto.EventDetailInfo;
import ee.valiit.suvepiduback.summerevent.eventdetail.dto.EventDetailInfoExtended;
import ee.valiit.suvepiduback.util.LocalDateConverter;
import ee.valiit.suvepiduback.util.LocalTimeConverter;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {LocalTimeConverter.class, LocalDateConverter.class})
public interface EventDetailMapper {

    @Mapping(expression = "java(LocalDateConverter.stringToLocalDate(eventDetailInfo.getDate()))", target = "date")
    @Mapping(expression = "java(LocalTimeConverter.stringToLocalTime(eventDetailInfo.getStartTime()))", target = "startTime")
    @Mapping(expression = "java(LocalTimeConverter.stringToLocalTime(eventDetailInfo.getEndTime()))", target = "endTime")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "longitude", target = "longitude")
    @Mapping(source = "latitude", target = "latitude")
    EventDetail toEventDetail(EventDetailInfo eventDetailInfo);

    @Mapping(source = "county.id",target = "countyId")
    @Mapping(expression = "java(LocalDateConverter.localDateToDateInputString(eventDetail.getDate()))", target = "date")
    @Mapping(expression = "java(LocalTimeConverter.localTimeToString(eventDetail.getStartTime()))", target = "startTime")
    @Mapping(expression = "java(LocalTimeConverter.localTimeToString(eventDetail.getEndTime()))", target = "endTime")
    EventDetailInfo toEventDetailInfo(EventDetail eventDetail);


    @Mapping(source = "id",target = "eventDetailId")
    @Mapping(source = "county.id",target = "countyId")
    @Mapping(source = "county.county",target = "countyName")
    @Mapping(expression = "java(LocalDateConverter.localDateToString(eventDetail.getDate()))", target = "date")
    @Mapping(expression = "java(LocalTimeConverter.localTimeToString(eventDetail.getStartTime()))", target = "startTime")
    @Mapping(expression = "java(LocalTimeConverter.localTimeToString(eventDetail.getEndTime()))", target = "endTime")
    EventDetailInfoExtended toEventDetailInfoExtended(EventDetail eventDetail);

    List<EventDetailInfoExtended> toEventDetailInfosExtended(List<EventDetail> eventDetails);

    @Mapping(expression = "java(LocalDateConverter.stringToLocalDate(eventDetailInfo.getDate()))", target = "date")
    @Mapping(expression = "java(LocalTimeConverter.stringToLocalTime(eventDetailInfo.getStartTime()))", target = "startTime")
    @Mapping(expression = "java(LocalTimeConverter.stringToLocalTime(eventDetailInfo.getEndTime()))", target = "endTime")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "longitude", target = "longitude")
    @Mapping(source = "latitude", target = "latitude")
    void updateEventDetail(EventDetailInfo eventDetailInfo, @MappingTarget EventDetail eventDetail);

}