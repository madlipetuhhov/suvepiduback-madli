package ee.valiit.suvepiduback.summerevent.tickettype;

import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEventRepository;
import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketType;
import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketTypeMapper;
import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketTypeRepository;
import ee.valiit.suvepiduback.summerevent.tickettype.dto.TicketTypeInfo;
import ee.valiit.suvepiduback.summerevent.tickettype.dto.TicketTypeInfoExtended;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketTypeService {
    private final MainEventRepository mainEventRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final TicketTypeMapper ticketTypeMapper;

    public void addNewTicketTypes(Integer mainEventId, TicketTypeInfo ticketTypeInfo) {
        MainEvent mainEvent = mainEventRepository.getReferenceById(mainEventId);
        TicketType ticketType = ticketTypeMapper.toTicketType(ticketTypeInfo);
        ticketType.setMainEvent(mainEvent);
        ticketTypeRepository.save(ticketType);
    }

    public TicketTypeInfoExtended getTicketType(Integer ticketTypeId) {
        TicketType ticketType = ticketTypeRepository.getReferenceById(ticketTypeId);
        return ticketTypeMapper.toTicketTypeInfoExtended(ticketType);
    }

    public List<TicketTypeInfoExtended> getTicketTypes(Integer mainEventId) {
        MainEvent mainEvent = mainEventRepository.getReferenceById(mainEventId);
        List<TicketType> ticketTypes = ticketTypeRepository.findTicketTypesBy(mainEvent.getId());
        return ticketTypeMapper.toTicketTypeInfosExtended(ticketTypes);
    }

    public void editTicketType(TicketTypeInfoExtended ticketTypeInfoExtended) {
        TicketType ticketType = ticketTypeRepository.getReferenceById(ticketTypeInfoExtended.getTicketTypeId());
        ticketTypeMapper.updateTicketType(ticketTypeInfoExtended, ticketType);
        ticketTypeRepository.save(ticketType);
    }


}
