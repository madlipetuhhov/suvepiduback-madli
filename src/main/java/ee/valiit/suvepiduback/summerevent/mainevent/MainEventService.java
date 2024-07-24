package ee.valiit.suvepiduback.summerevent.mainevent;

import ee.valiit.suvepiduback.domain.account.business.Business;
import ee.valiit.suvepiduback.domain.account.business.BusinessRepository;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetail;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetailMapper;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetailRepository;
import ee.valiit.suvepiduback.domain.event.eventdetail.county.County;
import ee.valiit.suvepiduback.domain.event.eventdetail.county.CountyMapper;
import ee.valiit.suvepiduback.domain.event.eventdetail.county.CountyRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEventMapper;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEventRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.EventCategory;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.EventCategoryRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.category.Category;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.category.CategoryRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.EventFeature;
import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.EventFeatureRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.feature.Feature;
import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.feature.FeatureRepository;
import ee.valiit.suvepiduback.domain.ticket.eventticket.EventTicket;
import ee.valiit.suvepiduback.domain.ticket.eventticket.EventTicketRepository;
import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketType;
import ee.valiit.suvepiduback.domain.ticket.tickettype.TicketTypeRepository;
import ee.valiit.suvepiduback.summerevent.Status;
import ee.valiit.suvepiduback.summerevent.county.dto.CountyInfo;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.EventInfo;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfo;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfoExtended;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfoShort;
import ee.valiit.suvepiduback.util.StringConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MainEventService {

    private final MainEventRepository mainEventRepository;
    private final BusinessRepository businessRepository;
    private final EventDetailRepository eventDetailRepository;
    private final CountyRepository countyRepository;
    private final EventFeatureRepository eventFeatureRepository;
    private final FeatureRepository featureRepository;
    private final CategoryRepository categoryRepository;
    private final EventCategoryRepository eventCategoryRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final EventTicketRepository eventTicketRepository;

    private final MainEventMapper mainEventMapper;
    private final CountyMapper countyMapper;
    private final EventDetailMapper eventDetailMapper;

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

        List<EventDetail> eventDetails = eventDetailRepository.findEventDetailsBy(mainEventId);
        List<EventInfo.EventDetail> eventInfoEventDetail = eventDetailMapper.toEventInfoEventDetail(eventDetails);

        // county Id-de võtmine eventDetails-ist ja selle järgi county nimede otsimine
        List<Integer> countyIds = new ArrayList<>();
        for (EventDetail eventDetail : eventDetails) {
            countyIds.add(eventDetail.getCounty().getId());
        }
        List<County> counties = countyRepository.findAllById(countyIds);
//        siin viitab varasematl tehtud CountyInfo DTO-le, kas nii saab?
        List<CountyInfo> countyInfos = countyMapper.toCountyInfos(counties);

        // Feature ID-de võtmine mainEventId abil tabelist ja siis nende Featurite nimede leidmine Featuride tabelist
        List<EventFeature> eventFeatures = eventFeatureRepository.findEventFeaturesBy(mainEventId);
        List<Integer> eventFeatureIds = new ArrayList<>();
        for (EventFeature eventFeature : eventFeatures) {
            eventFeatureIds.add(eventFeature.getFeature().getId());
        }
        List<Feature> features = featureRepository.findAllById(eventFeatureIds);


        // Category ID-de võtmine mainEventId abil tabelist ja siis nende Category-de nimede leidmine Featuride tabelist
        List<EventCategory> eventCategories = eventCategoryRepository.findEventCategoriesBy(mainEventId);
        List<Integer> eventCategoryIds = new ArrayList<>();
        for (EventCategory eventCategory : eventCategories) {
            eventCategoryIds.add(eventCategory.getCategory().getId());
        }
        List<Category> categories = categoryRepository.findAllById(eventCategoryIds);


        //  tickettype-ide leidmine mainEventId abil ja ticketTypeId-de eraldamine listiks, et hiljem otsida kogused ja saadavuse
        List<TicketType> ticketTypes = ticketTypeRepository.findTicketTypesBy(mainEventId);
        List<Integer> ticketTypeIds = new ArrayList<>();
        for (TicketType ticketType : ticketTypes) {
            ticketTypeIds.add(ticketType.getId());
        }
        List<EventTicket> eventTickets = eventTicketRepository.findAllById(ticketTypeIds);

        // DTO-le info külge panemine
        eventInfo.setCounties(countyInfos);
        eventInfo.setEventDetails(eventInfoEventDetail);


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

