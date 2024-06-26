package ee.valiit.suvepiduback.summerevent.ticket;

import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetail;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetailRepository;
import ee.valiit.suvepiduback.domain.ticket.eventticket.EventTicket;
import ee.valiit.suvepiduback.domain.ticket.eventticket.EventTicketMapper;
import ee.valiit.suvepiduback.domain.ticket.eventticket.EventTicketRepository;
import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketType;
import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketTypeRepository;
import ee.valiit.suvepiduback.summerevent.Status;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketInfo;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketRequest;
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

    public void addEventTickets(Integer eventDetailId, EventTicketRequest eventTicketRequest) {
        EventDetail eventDetail = eventDetailRepository.getReferenceById(eventDetailId);
        TicketType ticketType = ticketTypeRepository.getReferenceById(eventTicketRequest.getTicketTypeId());
        EventTicket eventTicket = eventTicketMapper.toEventTicket(eventTicketRequest);
        eventTicket.setEventDetail(eventDetail);
        eventTicket.setTicketType(ticketType);
        eventTicketRepository.save(eventTicket);
    }

    public EventTicketInfo getEventTicket(Integer eventTicketId) {
        EventTicket eventTicket = eventTicketRepository.getReferenceById(eventTicketId);
        return eventTicketMapper.toEventTicketInfo(eventTicket);
    }

    public List<EventTicketInfo> getEventTickets(Integer eventDetailId) {
        List<EventTicket> eventTickets = eventTicketRepository.findEventTicketsBy(eventDetailId, Status.ACTIVE);
        return eventTicketMapper.toEventTicketInfos(eventTickets);
    }

    public void editEventTicket(EventTicketInfo eventTicketInfo) {
        EventTicket eventTicket = eventTicketRepository.getReferenceById(eventTicketInfo.getEventTicketId());
        eventTicketMapper.updateEventTicket(eventTicketInfo, eventTicket);
        eventTicketRepository.save(eventTicket);
    }

    public Integer removeEventTicket(Integer eventTicketId) {
        EventTicket eventTicket = eventTicketRepository.getReferenceById(eventTicketId);
        eventTicket.setStatus(Status.DEACTIVE);
        eventTicketRepository.save(eventTicket);
        return eventTicketId;
    }
}
