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

    @PostMapping("/event/categories")
    @Operation(summary = "Create categories to the event by mainEventId.",
            description = "Creates categories in the database for the event using mainEventId (query parameter) and an array of categories (JSON payload).")
    public void updateCategories(@RequestParam Integer mainEventId, @RequestBody List<CategoryInfo> categoryInfos) {
        eventCategoryService.updateCategories(mainEventId, categoryInfos);
    }

    @GetMapping("/event/categories")
    @Operation(summary = "Retrieve an array of selected categories by mainEventId.",
            description = "Retrieves an array of selected categories of the event from the database using mainEventId (query parameter). Returns an array of selected categories.")
    public List<EventCategoryInfo> getEventCategoriesForView(@RequestParam Integer mainEventId) {
        return eventCategoryService.getEventCategoriesForView(mainEventId);
    }

    @GetMapping("/event/categories-modal")
    @Operation(summary = "Retrieve an array of selected categories by mainEventId for modal.",
            description = "Retrieves an array of selected categories of the event from the database using mainEventId (query parameter). Returns an array of selected categories.")
    public List<CategoryInfo> getEventCategoriesForModal(@RequestParam Integer mainEventId) {
        return eventCategoryService.getEventCategoriesForModal(mainEventId);
    }

    @PutMapping("/event/categories-modal")
    @Operation(summary = "Update event categories.",
            description = "Updates an existing event categories in the database using mainEventId (query parameter) and an array of categories (JSON payload).")
    public void editEventCategories(@RequestParam Integer mainEventId, @RequestBody List<CategoryInfo> categoryInfos) {
        eventCategoryService.editEventCategories(mainEventId, categoryInfos);
    }


}
