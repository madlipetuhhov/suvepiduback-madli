package ee.valiit.suvepiduback.summerevent.ticket;

import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetail;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetailRepository;
import ee.valiit.suvepiduback.domain.ticket.eventticket.*;
import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketType;
import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketTypeMapper;
import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketTypeRepository;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketInfo;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketRequest;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketTypeInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class TicketService {

    private final EventDetailRepository eventDetailRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final EventTicketRepository eventTicketRepository;
    private final EventTicketMapper eventTicketMapper;
    private final TicketTypeMapper ticketTypeMapper;


    public void addNewTicket(EventTicketRequest eventTicketRequest) {
        EventDetail eventDetail = eventDetailRepository.getReferenceById(eventTicketRequest.getEventDetailId());
        TicketType ticketType = ticketTypeRepository.getReferenceById(eventTicketRequest.getTicketTypeId());
        EventTicket eventTicket = eventTicketMapper.toEventTicket(eventTicketRequest);
        eventTicket.setEventDetail(eventDetail);
        eventTicket.setTicketType(ticketType);
        eventTicketRepository.save(eventTicket);
    }

    public List<EventTicketInfo> getEventTickets(Integer eventDetailId) {
        List<EventTicket> eventTickets = eventTicketRepository.findEventTicketsBy(eventDetailId);
        return eventTicketMapper.toEventTicketInfos(eventTickets);
    }

    public List<EventTicketTypeInfo> getEventTicketTypes(Integer mainEventId) {
        List<TicketType> ticketTypes = ticketTypeRepository.findTicketTypesBy(mainEventId);
        return ticketTypeMapper.toEventTicketTypeInfos(ticketTypes);

    }
}
