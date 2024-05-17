package ee.valiit.suvepiduback.domain.ticket.eventticket;

import ee.valiit.suvepiduback.summerevent.Status;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketInfo;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventTicketMapper {

    @Mapping(source = "total", target = "total")
    @Mapping(source = "total", target = "available")
    @Mapping(constant = Status.ACTIVE, target = "status")
    EventTicket toEventTicket(EventTicketRequest eventTicketRequest);

    @Mapping(source = "total", target = "total")
    @Mapping(source = "available", target = "available")
    @Mapping(constant = Status.ACTIVE, target = "status")
    @Mapping(source = "ticketType.name", target = "ticketTypeName")
    EventTicketInfo toEventTicketInfo(EventTicket eventTicket);

    List<EventTicketInfo> toEventTicketInfos(List<EventTicket> eventTickets);

}