package ee.valiit.suvepiduback.domain.ticket.tickettype;

import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketTypeInfo;
import ee.valiit.suvepiduback.summerevent.tickettype.dto.TicketTypeInfo;
import ee.valiit.suvepiduback.summerevent.tickettype.dto.TicketTypeInfoExtended;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketTypeMapper {

    @Mapping(source = "ticketTypeName", target = "name")
    @Mapping(source = "ticketTypePrice", target = "price")
    TicketType toTicketType(TicketTypeInfo ticketTypeInfo);

    @Mapping(source = "mainEvent.id", target = "mainEventId")
    @Mapping(source = "id", target = "ticketTypeId")
    @Mapping(source = "name", target = "ticketTypeName")
    @Mapping(source = "price", target = "ticketTypePrice")
    TicketTypeInfoExtended toTicketTypeInfoExtended(TicketType ticketType);

    List<TicketTypeInfoExtended> toTicketTypeInfosExtended(List<TicketType> ticketTypes);

    @Mapping(target = "mainEvent.id", source = "mainEventId")
    @Mapping(target = "price", source = "ticketTypePrice")
    @Mapping(target = "name", source = "ticketTypeName")
    void updateTicketType(TicketTypeInfoExtended ticketTypeInfoExtended, @MappingTarget TicketType ticketType);

    @Mapping(source = "id", target = "eventTicketTypeId")
    @Mapping(source = "name", target = "eventTicketTypeName")
    EventTicketTypeInfo toEventTicketTypeInfo(TicketType ticketType);


    List <EventTicketTypeInfo> toEventTicketTypeInfos(List <TicketType> ticketTypes);
}