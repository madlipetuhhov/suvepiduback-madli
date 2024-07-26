package ee.valiit.suvepiduback.domain.event.mainevent;

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
    @Mapping(expression = "java(StringConverter.bytesToString(mainEvent.getImageData()))", target = "imageData")
    EventInfo toEventInfo(MainEvent mainEvent);

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