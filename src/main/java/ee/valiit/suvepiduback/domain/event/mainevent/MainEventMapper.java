package ee.valiit.suvepiduback.domain.event.mainevent;

import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetail;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.EventCategory;
import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.EventFeature;
import ee.valiit.suvepiduback.domain.ticket.eventticket.EventTicket;
import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketType;
import ee.valiit.suvepiduback.summerevent.Status;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.EventInfo;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfo;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfoExtended;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfoShort;
import ee.valiit.suvepiduback.util.StringConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = {StringConverter.class})
public interface MainEventMapper {

    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(expression = "java(StringConverter.stringToBytes(mainEventInfo.getImageData()))", target = "imageData")
//    @Mapping(source = "", target = "eventDetailId")
//    @Mapping(source = "eventDetail.date", target = "date")
//    @Mapping(source = "eventDetail.startTime", target = "startTime")
//    @Mapping(source = "eventDetail.endTime", target = "endTime")
//    @Mapping(source = "eventDetail.address", target = "address")
//    @Mapping(source = "eventDetail.county.name", target = "countyName")
//    @Mapping(source = "eventDetail.longitude", target = "longitude")
//    @Mapping(source = "eventDetail.latitude", target = "latitude")
//    @Mapping(source = "eventFeature.id", target = "featureId")
//    @Mapping(source = "eventFeature.name", target = "featureName")
//    @Mapping(source = "eventCategory.id", target = "categoryId")
//    @Mapping(source = "eventCategory.name", target = "categoryName")
//    @Mapping(source = "ticketType.name", target = "ticketTypeName")
//    @Mapping(source = "ticketType.price", target = "ticketTypePrice")
//    @Mapping(source = "eventTicket.total", target = "total")
//    @Mapping(source = "", target = "available")
    EventInfo toEventInfo(MainEvent mainEvent, List<EventDetail> eventDetails, List<EventFeature> eventFeatures, List<EventCategory> eventCategories, List<TicketType> ticketTypes, List<EventTicket> eventTickets);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(expression = "java(StringConverter.stringToBytes(mainEventInfo.getImageData()))", target = "imageData")
    @Mapping(constant = Status.ACTIVE, target = "status")
    MainEvent toMainEvent(MainEventInfo mainEventInfo);

    @Mapping(source = "id", target = "mainEventId")
    @Mapping(source = "title", target = "mainEventTitle")
    MainEventInfoShort toMainEventInfoShort(MainEvent mainEvent);

    @Mapping(source = "id", target = "mainEventId")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(expression = "java(StringConverter.bytesToString(mainEvent.getImageData()))", target = "imageData")
    MainEventInfoExtended toMainEventInfoExtended(MainEvent mainEvent);

    List<MainEventInfoExtended> toMainEventInfosExtended(List<MainEvent> mainEvents);

    @Mapping(source = "mainEventId", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(expression = "java(StringConverter.stringToBytes(mainEventInfoExtended.getImageData()))", target = "imageData")
    void updateMainEvent(MainEventInfoExtended mainEventInfoExtended, @MappingTarget MainEvent mainEvent);

}