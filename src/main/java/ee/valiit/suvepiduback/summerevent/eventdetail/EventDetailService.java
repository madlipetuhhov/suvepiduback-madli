package ee.valiit.suvepiduback.summerevent.eventdetail;

import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetail;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetailMapper;
import ee.valiit.suvepiduback.domain.event.eventdetail.EventDetailRepository;
import ee.valiit.suvepiduback.domain.event.eventdetail.county.County;
import ee.valiit.suvepiduback.domain.event.eventdetail.county.CountyRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEventRepository;
import ee.valiit.suvepiduback.summerevent.eventdetail.dto.EventDetailInfo;
import ee.valiit.suvepiduback.summerevent.eventdetail.dto.EventDetailInfoExtended;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EventDetailService {

    private final EventDetailRepository eventDetailRepository;
    private final MainEventRepository mainEventRepository;
    private final CountyRepository countyRepository;

    private final EventDetailMapper eventDetailMapper;

    public Integer addEventDetail(Integer mainEventId, EventDetailInfo eventDetailInfo) {
        MainEvent mainEvent = mainEventRepository.getReferenceById(mainEventId);
        County county = countyRepository.getReferenceById(eventDetailInfo.getCountyId());
        EventDetail eventDetail = eventDetailMapper.toEventDetail(eventDetailInfo);
        eventDetail.setMainEvent(mainEvent);
        eventDetail.setCounty(county);
        eventDetailRepository.save(eventDetail);

        return eventDetail.getId();
    }

    public List<EventDetailInfoExtended> getEventDetails(Integer mainEventId) {
        List<EventDetail> eventDetails = eventDetailRepository.findEventDetailsBy(mainEventId);
        return eventDetailMapper.toEventDetailInfosExtended(eventDetails);
    }

    public EventDetailInfo getEventDetail(Integer eventDetailId) {
        EventDetail eventDetail = eventDetailRepository.getReferenceById(eventDetailId);
        return eventDetailMapper.toEventDetailInfo(eventDetail);
    }

    public void editEventDetail(Integer eventDetailId, EventDetailInfo eventDetailInfo) {
        EventDetail eventDetail = eventDetailRepository.getReferenceById(eventDetailId);
        eventDetailMapper.updateEventDetail(eventDetailInfo, eventDetail);
        eventDetailRepository.save(eventDetail);
    }
}



