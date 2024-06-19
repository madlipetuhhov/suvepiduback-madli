package ee.valiit.suvepiduback.summerevent.mainevent;

import ee.valiit.suvepiduback.domain.account.business.Business;
import ee.valiit.suvepiduback.domain.account.business.BusinessRepository;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetail;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetailRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEventMapper;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEventRepository;
import ee.valiit.suvepiduback.summerevent.Status;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfo;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfoExtended;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MainEventService {

    private final MainEventRepository mainEventRepository;
    private final BusinessRepository businessRepository;
    private final EventDetailRepository eventDetailRepository;
    private final MainEventMapper mainEventMapper;

    public Integer addNewMainEvent(Integer businessId, MainEventInfo mainEventInfo) {
        Business business = businessRepository.getReferenceById(businessId);
        MainEvent mainEvent = mainEventMapper.toMainEvent(mainEventInfo);
        mainEvent.setBusiness(business);
        mainEventRepository.save(mainEvent);
        return mainEvent.getId();
    }

    public MainEventInfoExtended getMainEvent(Integer mainEventId) {
        MainEvent mainEvent = mainEventRepository.findMainEventBy(mainEventId, Status.ACTIVE);
        return mainEventMapper.toMainEventInfoExtended(mainEvent);
    }

    public List<MainEventInfoExtended> getMainEvents(Integer businessId) {
        List<MainEvent> mainEvents = mainEventRepository.findMainEventsBy(businessId, Status.ACTIVE);
        return mainEventMapper.toMainEventInfosExtended(mainEvents);
    }

    public String getMainEventName(Integer eventDetailId) {
        EventDetail eventDetail = eventDetailRepository.getReferenceById(eventDetailId);
        MainEvent mainEvent = eventDetail.getMainEvent();
        return mainEvent.getTitle();
    }

    public void editMainEvent(MainEventInfoExtended mainEventInfoExtended) {
        MainEvent mainEvent = mainEventRepository.getReferenceById(mainEventInfoExtended.getMainEventId());
        mainEventMapper.updateMainEvent(mainEventInfoExtended, mainEvent);
        mainEventRepository.save(mainEvent);
    }

    public Integer removeMainEvent(Integer mainEventId) {
        MainEvent mainEvent = mainEventRepository.getReferenceById(mainEventId);
        mainEvent.setStatus(Status.DEACTIVE);
        mainEventRepository.save(mainEvent);
        return mainEventId;
    }
}

