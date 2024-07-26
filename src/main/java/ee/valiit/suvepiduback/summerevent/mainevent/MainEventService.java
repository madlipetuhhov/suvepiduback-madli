package ee.valiit.suvepiduback.summerevent.mainevent;

import ee.valiit.suvepiduback.domain.account.business.Business;
import ee.valiit.suvepiduback.domain.account.business.BusinessRepository;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetail;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetailMapper;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetailRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEventMapper;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEventRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.EventCategory;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.EventCategoryMapper;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.EventCategoryRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.EventFeature;
import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.EventFeatureMapper;
import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.EventFeatureRepository;
import ee.valiit.suvepiduback.domain.ticket.eventticket.EventTicket;
import ee.valiit.suvepiduback.domain.ticket.eventticket.EventTicketMapper;
import ee.valiit.suvepiduback.domain.ticket.eventticket.EventTicketRepository;
import ee.valiit.suvepiduback.summerevent.Status;
import ee.valiit.suvepiduback.summerevent.eventcategory.dto.EventCategoryInfo;
import ee.valiit.suvepiduback.summerevent.eventdetail.dto.EventDetailInfoWithCounty;
import ee.valiit.suvepiduback.summerevent.eventfeature.dto.EventFeatureInfo;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.EventInfo;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfo;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfoExtended;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfoShort;
import ee.valiit.suvepiduback.summerevent.ticket.dto.EventTicketInfoWithPrice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MainEventService {

    private final MainEventRepository mainEventRepository;
    private final EventFeatureRepository eventFeatureRepository;
    private final EventCategoryRepository eventCategoryRepository;
    private final EventDetailRepository eventDetailRepository;
    private final EventTicketRepository eventTicketRepository;
    private final BusinessRepository businessRepository;

    private final MainEventMapper mainEventMapper;
    private final EventFeatureMapper eventFeatureMapper;
    private final EventCategoryMapper eventCategoryMapper;
    private final EventDetailMapper eventDetailMapper;
    private final EventTicketMapper eventTicketMapper;

    public Integer addNewMainEvent(Integer businessId, MainEventInfo mainEventInfo) {
        Business business = getOptionalBusiness(businessId);
        MainEvent mainEvent = mainEventMapper.toMainEvent(mainEventInfo);
        mainEvent.setBusiness(business);
        mainEventRepository.save(mainEvent);

        return mainEvent.getId();
    }

    private Business getOptionalBusiness(Integer businessId) {
        Optional<Business> optionalBusiness = businessRepository.findById(businessId);
        if (optionalBusiness.isEmpty()) {
            throw new IllegalArgumentException("Business not found with id: " + businessId);
        }
        return optionalBusiness.get();
    }

    public MainEventInfoExtended getMainEvent(Integer mainEventId) {
        MainEvent mainEvent = mainEventRepository.findMainEventBy(mainEventId, Status.ACTIVE);
        return mainEventMapper.toMainEventInfoExtended(mainEvent);
    }

    public List<MainEventInfoExtended> getMainEvents(Integer businessId) {
        List<MainEvent> mainEvents = mainEventRepository.findMainEventsBy(businessId, Status.ACTIVE);
        return mainEventMapper.toMainEventInfosExtended(mainEvents);
    }

    public MainEventInfoShort getMainEventNameAndId(Integer eventDetailId) {
        EventDetail eventDetail = eventDetailRepository.getReferenceById(eventDetailId);
        MainEvent mainEvent = eventDetail.getMainEvent();
        return mainEventMapper.toMainEventInfoShort(mainEvent);
    }

    public EventInfo getEventInfo(Integer mainEventId) {
        MainEvent mainEvent = mainEventRepository.getReferenceById(mainEventId);
        EventInfo eventInfo = mainEventMapper.toEventInfo(mainEvent);

        List<EventFeature> eventFeatures = eventFeatureRepository.findEventFeaturesBy(mainEventId);
        List<EventFeatureInfo> eventFeatureInfos = eventFeatureMapper.toEventFeatureInfos(eventFeatures);
        eventInfo.setFeatures(eventFeatureInfos);

        List<EventCategory> eventCategories = eventCategoryRepository.findEventCategoriesBy(mainEventId);
        List<EventCategoryInfo> eventCategoryInfos = eventCategoryMapper.toEventCategoryInfos(eventCategories);
        eventInfo.setCategories(eventCategoryInfos);

        List<EventDetail> eventDetails = eventDetailRepository.findEventDetailsBy(mainEventId);
        List<EventDetailInfoWithCounty> eventDetailInfosWithCounty = eventDetailMapper.toEventDetailInfosWithCounty(eventDetails);
        eventInfo.setEventDetails(eventDetailInfosWithCounty);

        List<EventTicket> eventTickets = eventTicketRepository.findMainEventTicketsBy(mainEventId);
        List<EventTicketInfoWithPrice> eventTicketInfosWithPrice = eventTicketMapper.toEventTicketInfosWithPrice(eventTickets);
        eventInfo.setTickets(eventTicketInfosWithPrice);

        return eventInfo;
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

