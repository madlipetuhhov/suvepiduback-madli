package ee.valiit.suvepiduback.summerevent.eventcategory;

import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEventRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.EventCategory;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.EventCategoryMapper;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.EventCategoryRepository;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.category.Category;
import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.category.CategoryRepository;
import ee.valiit.suvepiduback.summerevent.category.dto.CategoryInfo;
import ee.valiit.suvepiduback.summerevent.eventcategory.dto.EventCategoryInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventCategoryService {
    private final EventCategoryRepository eventCategoryRepository;
    private final MainEventRepository mainEventRepository;
    private final CategoryRepository categoryRepository;
    private final EventCategoryMapper eventCategoryMapper;


    public void updateCategories(Integer mainEventId, List<CategoryInfo> categoryInfos) {
        MainEvent mainEvent = mainEventRepository.getReferenceById(mainEventId);
        createAndSaveEventCategories(mainEvent, categoryInfos);
    }

    private void createAndSaveEventCategories(MainEvent mainEvent, List<CategoryInfo> categoryInfos) {
        List<EventCategory> eventCategories = createEventCategories(categoryInfos, mainEvent);
        eventCategoryRepository.saveAll(eventCategories);
    }

    private List<EventCategory> createEventCategories(List<CategoryInfo> categoryInfos, MainEvent mainEvent) {
        List<EventCategory> eventCategories = new ArrayList<>();
        for (CategoryInfo categoryInfo : categoryInfos) {
//            esimene on andmetüüp (deklareerin sealt muutujat, võib ka olla var), teine on ajutine muutuja for loopi sees
//            (listis andme tükk on iga kord selle muutuja sees, kui loop käivitub). Kolmas on massiiv, mida loopin ja
//            loop käib nii mitu korda läbi kui suur on massiiv.
            if (categoryInfo.getIsAvailable()) {
                Category category = categoryRepository.getReferenceById(categoryInfo.getCategoryId());
                EventCategory eventCategory = new EventCategory();
                eventCategory.setMainEvent(mainEvent);
                eventCategory.setCategory(category);
                eventCategories.add(eventCategory);
            }
        }
        return eventCategories;
    }

    public List<EventCategoryInfo> getEventCategoriesForView(Integer mainEventId) {
        List<EventCategory> eventCategories = eventCategoryRepository.findEventCategoriesBy(mainEventId);
        return eventCategoryMapper.toEventCategoryInfos(eventCategories);
    }

    //    EventFeatureService klassis on allolev mneetod kommentaarideta ja alammeetoditeks tehtud
    public List<CategoryInfo> getEventCategoriesForModal(Integer mainEventId) {
        // siin kõik kategooriad kätte saadud
        List<Category> categories = categoryRepository.findAll();
        // siin on list kategooriatest mis on main eventi kuljes
        List<EventCategory> eventCategories = eventCategoryRepository.findEventCategoriesBy(mainEventId);
        // siin on uus list DTOdega mappimiseks
        List<CategoryInfo> categoryInfos = new ArrayList<>();
        // siin loopime yle kategooriate
        for (Category category : categories) {
            // siin teeme uue DTO (mappimine ise)
            CategoryInfo categoryInfo = new CategoryInfo();
            // siin mapime uuele DTOle id ja nime
            categoryInfo.setCategoryId(category.getId());
            categoryInfo.setCategoryName(category.getName());
            // siin loopime eventcategoried et leida kas on available v mitte
            for (EventCategory eventCategory : eventCategories) {
                // kui leiame vaste, siis available = true
                if (category.getId().equals(eventCategory.getCategory().getId())) {
                    categoryInfo.setIsAvailable(true);
                }
            }
            // siin lisame uue DTO meie eelnevalt loodud uue DTO listi sisse
            categoryInfos.add(categoryInfo);
        }

        return categoryInfos;
    }

    //    EventFeatureService klassis on allolev mneetod kommentaarideta ja alammeetoditeks tehtud
    public void editEventCategories(Integer mainEventId, List<CategoryInfo> categoryInfos) {
        for (CategoryInfo categoryInfo : categoryInfos) {
            // vaatame kas see kategooria on true (kas on valitud frondist)
            Optional<EventCategory> optionalEventCategory = eventCategoryRepository.findEventCategoryBy(mainEventId, categoryInfo.getCategoryId());
            if (categoryInfo.getIsAvailable()) {
                // kui on true, siis kontrollime, kas see on juba varem salvestatud event_category tabelis.
                // kui on salvestatud, siis ei tee midagi. kui ei ole, siis salvestame sinna.
                // salvestatakse juurde need kategooriad, mida on vaja juurde
                if (optionalEventCategory.isEmpty()) {
                    EventCategory eventCategory = new EventCategory();
                    eventCategory.setMainEvent(mainEventRepository.getReferenceById(mainEventId));
                    eventCategory.setCategory(categoryRepository.getReferenceById(categoryInfo.getCategoryId()));
                    eventCategoryRepository.save(eventCategory);
                }
                // siin tegeleme nende kategooriatega mis on false (ehk mida enam pole vaja).
            } else {
                // siis kontrollime, kas see on juba varem salvestatud event_category tabelis.
                // kui siin tabelis on olemas, siis peame kustutama (kustutatakse need mida enam pole vaja)
                if (optionalEventCategory.isPresent()) {
                    eventCategoryRepository.delete(optionalEventCategory.get());
                }
            }
        }
    }

}
