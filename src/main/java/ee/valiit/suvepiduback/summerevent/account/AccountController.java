package ee.valiit.suvepiduback.summerevent.account;

import ee.valiit.suvepiduback.summerevent.account.dto.BusinessInfo;
import ee.valiit.suvepiduback.summerevent.account.dto.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/account/user")
    @Operation(summary = "Create a new user account.",
            description = "Creates a new user account in the database using the provided user object (JSON payload).")
    public void addNewUser(@RequestBody @Valid UserInfo userInfo) {
        accountService.addNewUser(userInfo);
    }

    @PostMapping("/account/business")
    @Operation(summary = "Create a new business account.",
            description = "Creates a new business account in the database using the provided business object (JSON payload).")
    public void addNewBusiness(@RequestBody BusinessInfo businessInfo) {
        accountService.addNewBusiness(businessInfo);
    }


}
