package ee.valiit.suvepiduback.summerevent.category;

import ee.valiit.suvepiduback.summerevent.category.dto.CategoryInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    @Operation(summary = "Create a an array of categories.",
            description = "Creates an array of categories. Returns an array of categories.")
    public List<CategoryInfo> executeCategoriesList() {
        return categoryService.executeCategoriesList();
    }

}
