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
    @Operation(summary = "Adding categories to the event.",
            description = "Categories are added to the database for the event using mainEventId.")
    public void updateCategories(@RequestParam Integer mainEventId, @RequestBody List<CategoryInfo> categoryInfos) {
        eventCategoryService.updateCategories(mainEventId, categoryInfos);
    }

    @GetMapping("/event/categories")
    @Operation(summary = "Retrieving all selected categories from the database for the event.",
            description = "All categories of the event are fetched from the database using mainEventId to display in a table.")
    public List<EventCategoryInfo> getEventCategoriesForView(@RequestParam Integer mainEventId) {
        return eventCategoryService.getEventCategoriesForView(mainEventId);
    }

    @GetMapping("/event/categories-modal")
    @Operation(summary = "Retrieving all selected categories from the database for the event.",
            description = "All selected categories of the event are fetched from the database using mainEventId to display in the modal.")
    public List<CategoryInfo> getEventCategoriesForModal(@RequestParam Integer mainEventId) {
        return eventCategoryService.getEventCategoriesForModal(mainEventId);
    }

    @PutMapping("/event/categories-modal")
    @Operation(summary = "Modify existing categories data.",
            description = "In the database, the categories data of the existing event is overwritten using mainEventId.")
    public void editEventCategories(@RequestParam Integer mainEventId, @RequestBody List<CategoryInfo> categoryInfos) {
        eventCategoryService.editEventCategories(mainEventId, categoryInfos);
    }


}
