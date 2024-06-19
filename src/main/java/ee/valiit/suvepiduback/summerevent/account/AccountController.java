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
    @Operation(summary = "Adding a new user account.",
            description = "A new user account is added to the database.")
    public void addNewUser(@RequestBody @Valid UserInfo userInfo) {
        accountService.addNewUser(userInfo);
    }

    @PostMapping("/account/business")
    @Operation(summary = "Adding a new business to user account.",
            description = "A new business account is added to the database to user account.")
    public void addNewBusiness(@RequestBody BusinessInfo businessInfo) {
        accountService.addNewBusiness(businessInfo);
    }


}
