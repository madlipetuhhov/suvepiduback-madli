package ee.valiit.suvepiduback.summerevent.eventcategory;

import ee.valiit.suvepiduback.summerevent.category.dto.CategoryInfo;
import ee.valiit.suvepiduback.summerevent.eventcategory.dto.EventCategoryInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class EventCategoryController {
    private final EventCategoryService eventCategoryService;

    //    post meetod ei ole frondis kasutusel, put meetodi abil toimub muutmine
    @PostMapping("/event/categories")
    @Operation(summary = "Uuele sündmusele kategooriate lisamine.",
            description = "Süsteemi lisatakse sündmusele juurde kategooriad mainEventId abil.")
    public void updateCategories(@RequestParam Integer mainEventId, @RequestBody List<CategoryInfo> categoryInfos) {
        eventCategoryService.updateCategories(mainEventId, categoryInfos);
    }

    @GetMapping("/event/categories")
    @Operation(summary = "Kõikide valitud kategooriate andmebaasist toomine vastava sündmuse kohta tabelis kuvamiseks.",
            description = "Andmebaasist tuuakse vastava sündmuse kõik kategooriad mainEventId abil.")
    public List<EventCategoryInfo> getEventCategoriesForView(@RequestParam Integer mainEventId) {
        return eventCategoryService.getEventCategoriesForView(mainEventId);
    }

    @GetMapping("/event/categories-modal")
    @Operation(summary = "Kõikide valitud kategooriate andmebaasist toomine vastava sündmuse kohta modalis kuvamiseks.",
            description = "Andmebaasist tuuakse vastava sündmuse kõik kategooriad mainEventId abil.")
    public List<CategoryInfo> getEventCategoriesForModal(@RequestParam Integer mainEventId) {
        return eventCategoryService.getEventCategoriesForModal(mainEventId);
    }

    @PutMapping("/event/categories-modal")
    @Operation(summary = "Olemasolevate kategooriate andmete muutmine.",
            description = "Andmebaasis kirjutatakse üle andmed.")
    public void editEventCategories(@RequestParam Integer mainEventId, @RequestBody List<CategoryInfo> categoryInfos) {
        eventCategoryService.editEventCategories(mainEventId, categoryInfos);
    }


}
