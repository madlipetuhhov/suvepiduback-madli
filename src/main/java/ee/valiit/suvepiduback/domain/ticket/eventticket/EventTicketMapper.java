package ee.valiit.suvepiduback.domain.ticket.eventticket;

import ee.valiit.suvepiduback.summerevent.Status;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketInfo;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketInfoWithPrice;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventTicketMapper {

    @Mapping(source = "ticketTypeId", target = "id")
    @Mapping(source = "total", target = "total")
    @Mapping(source = "available", target = "available")
    @Mapping(constant = Status.ACTIVE, target = "status")
    EventTicket toEventTicket(EventTicketRequest eventTicketRequest);

    @Mapping(source = "id", target = "eventTicketId")
    @Mapping(source = "total", target = "total")
    @Mapping(source = "available", target = "available")
    @Mapping(constant = Status.ACTIVE, target = "status")
    @Mapping(source = "ticketType.name", target = "ticketTypeName")
    EventTicketInfo toEventTicketInfo(EventTicket eventTicket);
    @IterableMapping(elementTargetType = EventTicketInfo.class)
    List<EventTicketInfo> toEventTicketInfos(List<EventTicket> eventTickets);

    @Mapping(source = "id", target = "eventTicketId")
    @Mapping(source = "ticketType.name", target = "ticketTypeName")
    @Mapping(source = "ticketType.price", target = "ticketTypePrice")
    @Mapping(source = "total", target = "total")
    @Mapping(source = "available", target = "available")
    @Mapping(constant = Status.ACTIVE, target = "status")
    EventTicketInfoWithPrice toEventTicketInfoWithPrice(EventTicket eventTicket);
    @IterableMapping(elementTargetType = EventTicketInfoWithPrice.class)
    List<EventTicketInfoWithPrice> toEventTicketInfosWithPrice(List<EventTicket> eventTickets);

    @Mapping(source = "eventTicketId", target = "id")
    @Mapping(source = "ticketTypeName", target = "ticketType.name")
    @Mapping(source = "total", target = "total")
    @Mapping(source = "available", target = "available")
    @Mapping(constant = Status.ACTIVE, target = "status")
    void updateEventTicket(EventTicketInfo eventTicketInfo, @MappingTarget EventTicket eventTicket);
}