package ee.valiit.suvepiduback.domain.event.mainevent;

import ee.valiit.suvepiduback.summerevent.Status;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfo;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfoExtended;
import ee.valiit.suvepiduback.util.StringConverter;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {StringConverter.class})
public interface MainEventMapper {

    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(expression = "java(StringConverter.stringToBytes(mainEventInfo.getImageData()))", target = "imageData")
    @Mapping(constant = Status.ACTIVE, target = "status")
    MainEvent toMainEvent(MainEventInfo mainEventInfo);

    @Mapping(source = "id", target = "mainEventId")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(expression = "java(StringConverter.bytesToString(mainEvent.getImageData()))", target = "imageData")
    MainEventInfoExtended toMainEventInfoExtended(MainEvent mainEvent);

    List<MainEventInfoExtended> toMainEventInfosExtended(List<MainEvent> mainEvents);

    @Mapping(target = "id", source = "mainEventId")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(expression = "java(StringConverter.stringToBytes(mainEventInfoExtended.getImageData()))", target = "imageData")
    void updateMainEvent(MainEventInfoExtended mainEventInfoExtended, @MappingTarget MainEvent mainEvent);


}