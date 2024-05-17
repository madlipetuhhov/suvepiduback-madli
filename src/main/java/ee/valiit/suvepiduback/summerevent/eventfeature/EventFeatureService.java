package ee.valiit.suvepiduback.summerevent.eventfeature;

import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEventRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.EventFeature;
import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.EventFeatureMapper;
import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.EventFeatureRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.feature.Feature;
import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.feature.FeatureRepository;
import ee.valiit.suvepiduback.summerevent.eventfeature.dto.EventFeatureInfo;
import ee.valiit.suvepiduback.summerevent.feature.dto.FeatureInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventFeatureService {
    private final EventFeatureRepository eventFeatureRepository;
    private final MainEventRepository mainEventRepository;
    private final FeatureRepository featureRepository;
    private final EventFeatureMapper eventFeatureMapper;

    public void updateFeatures(Integer mainEventId, List<FeatureInfo> featureInfos) {
        MainEvent mainEvent = mainEventRepository.getReferenceById(mainEventId);
        createAndSaveEventFeatures(mainEvent, featureInfos);
    }

    private void createAndSaveEventFeatures(MainEvent mainEvent, List<FeatureInfo> featureInfos) {
        List<EventFeature> eventFeatures = createEventFeatures(mainEvent, featureInfos);
        eventFeatureRepository.saveAll(eventFeatures);
    }

    private List<EventFeature> createEventFeatures(MainEvent mainEvent, List<FeatureInfo> featureInfos) {
        List<EventFeature> eventFeatures = new ArrayList<>();
        for (FeatureInfo featureInfo : featureInfos) {
            if (featureInfo.getIsAvailable()) {
                Feature feature = featureRepository.getReferenceById(featureInfo.getFeatureId());
                EventFeature eventFeature = new EventFeature();
                eventFeature.setMainEvent(mainEvent);
                eventFeature.setFeature(feature);
                eventFeatures.add(eventFeature);
            }
        }
        return eventFeatures;
    }

    public List<EventFeatureInfo> getEventFeaturesForView(Integer mainEventId) {
        List<EventFeature> eventFeatures = eventFeatureRepository.findEventFeaturesBy(mainEventId);
        return eventFeatureMapper.toEventFeatureInfos(eventFeatures);
    }


    public List<FeatureInfo> getEventFeaturesForModal(Integer mainEventId) {
        List<Feature> features = featureRepository.findAll();
        return createAndSaveEventFeaturesForModal(mainEventId, features);
    }

    //  EventCategoryService klassis on allolev meetod koos kommentaaridega, mis toimub mis real
    private List<FeatureInfo> createAndSaveEventFeaturesForModal(Integer mainEventId, List<Feature> features) {
        List<EventFeature> eventFeatures = eventFeatureRepository.findEventFeaturesBy(mainEventId);
        return createEventFeaturesForModal(features, eventFeatures);
    }

    private static List<FeatureInfo> createEventFeaturesForModal(List<Feature> features, List<EventFeature> eventFeatures) {
        List<FeatureInfo> featureInfos = new ArrayList<>();
        for (Feature feature : features) {
            FeatureInfo featureInfo = new FeatureInfo();
            featureInfo.setFeatureId(feature.getId());
            featureInfo.setFeatureName(feature.getName());
            for (EventFeature eventFeature : eventFeatures) {
                if (feature.getId().equals(eventFeature.getFeature().getId())) {
                    featureInfo.setIsAvailable(true);
                }
            }
            featureInfos.add(featureInfo);
        }
        return featureInfos;
    }

    //  EventCategoryService klassis on allolev meetod koos kommentaaridega, mis toimub mis real
    public void editEventFeatures(Integer mainEventId, List<FeatureInfo> featureInfos) {
        for (FeatureInfo featureInfo : featureInfos) {
            saveOrDeleteOptionalEventFeatures(mainEventId, featureInfo);
        }
    }

    private void saveOrDeleteOptionalEventFeatures(Integer mainEventId, FeatureInfo featureInfo) {
        Optional<EventFeature> optionalEventFeature = eventFeatureRepository.findEventFeatureBy(mainEventId, featureInfo.getFeatureId());
        if (featureInfo.getIsAvailable()) {
            createAndSaveOptionalEventFeatures(mainEventId, featureInfo, optionalEventFeature);
        } else {
            optionalEventFeature.ifPresent(eventFeatureRepository::delete);
        }
    }

    private void createAndSaveOptionalEventFeatures(Integer mainEventId, FeatureInfo featureInfo, Optional<EventFeature> optionalEventFeature) {
        if (optionalEventFeature.isEmpty()) {
            EventFeature eventFeature = new EventFeature();
            eventFeature.setMainEvent(mainEventRepository.getReferenceById(mainEventId));
            eventFeature.setFeature(featureRepository.getReferenceById(featureInfo.getFeatureId()));
            eventFeatureRepository.save(eventFeature);
        }
    }
}

