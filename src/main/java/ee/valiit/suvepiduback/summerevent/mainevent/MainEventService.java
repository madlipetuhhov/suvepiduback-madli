package ee.valiit.suvepiduback.summerevent.mainevent;

import ee.valiit.suvepiduback.domain.account.business.Business;
import ee.valiit.suvepiduback.domain.account.business.BusinessRepository;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetail;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetailRepository;
import ee.valiit.suvepiduback.domain.event.eventdetail.county.County;
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
import java.util.stream.Collectors;

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
        List<EventDetail> eventDetails = eventDetailRepository.findEventDetailsBy(mainEventId);

        // Extract event detail IDs
        List<Integer> eventDetailIds = new ArrayList<>();
        for (EventDetail eventDetail : eventDetails) {
            eventDetailIds.add(eventDetail.getId());
        }

        // Extract county ID from eventDetails and get county name
        Integer countyId = eventDetails.get(0).getCounty().getId();
        County county = countyRepository.getReferenceById(countyId);

        // Extract feature ID from eventFeatures and get feature names
        List<EventFeature> eventFeatures = eventFeatureRepository.findEventFeaturesBy(mainEventId);
        List<Integer> eventFeatureIds = new ArrayList<>();
        for (EventFeature eventFeature : eventFeatures) {
            eventFeatureIds.add(eventFeature.getId());
        }
        List<Feature> featureNames = featureRepository.findNamesBy(eventFeatureIds);

        // Extract category ID from eventCategories and get category names
        List<EventCategory> eventCategories = eventCategoryRepository.findEventCategoriesBy(mainEventId);
        List<Integer> eventCategoryIds = new ArrayList<>();
        for (EventCategory eventCategory : eventCategories) {
            eventCategoryIds.add(eventCategory.getId());
        }
        List<Category> categoryNames = categoryRepository.findNamesBy(eventCategoryIds);

        List<TicketType> ticketTypes = ticketTypeRepository.findTicketTypesBy(mainEventId);
        List<EventTicket> eventTickets = eventTicketRepository.findTicketsBy(eventDetailIds);

        // Create EventInfo DTO and populate its fields
        EventInfo eventInfo = new EventInfo();
        eventInfo.setTitle(mainEvent.getTitle());
        eventInfo.setDescription(mainEvent.getDescription());
        eventInfo.setImageData((Arrays.toString(StringConverter.stringToBytes(Arrays.toString(mainEvent.getImageData())))));
        eventInfo.setEventDetailId(eventDetails.get(0).getId());
        eventInfo.setDate(String.valueOf(eventDetails.get(0).getDate()));
        eventInfo.setStartTime(String.valueOf(eventDetails.get(0).getStartTime()));
        eventInfo.setEndTime(String.valueOf(eventDetails.get(0).getEndTime()));
        eventInfo.setAddress(eventDetails.get(0).getAddress());
        eventInfo.setCountyName(county.getCounty());
        eventInfo.setLongitude(eventDetails.get(0).getLongitude());
        eventInfo.setLatitude(eventDetails.get(0).getLatitude());
        eventInfo.setFeatureId(eventFeatures.get(0).getId());
        eventInfo.setFeatureName(featureNames.get(0).getName());
        eventInfo.setCategoryId(eventCategories.get(0).getId());
        eventInfo.setCategoryName(categoryNames.get(0).getName());
        eventInfo.setTicketTypeName(ticketTypes.get(0).getName());
        eventInfo.setTicketTypePrice(ticketTypes.get(0).getPrice());
        eventInfo.setTotal(eventTickets.get(0).getTotal());
        eventInfo.setAvailable(eventTickets.get(0).getAvailable());

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

