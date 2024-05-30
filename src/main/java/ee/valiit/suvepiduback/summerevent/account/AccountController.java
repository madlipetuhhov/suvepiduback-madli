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
    @Operation(summary = "Uue tavakasutaja konto lisamine.",
            description = "Andmebaasi lisatakse uus kasutaja.")
    public void addNewUser(@RequestBody @Valid UserInfo userInfo) {
        accountService.addNewUser(userInfo);
    }

    @PostMapping("/account/business")
    @Operation(summary = "Uue korraldaja konto lisamine.",
            description = "Süsteemi lisatakse uus korraldaja.")
    public void addNewBusiness(@RequestBody BusinessInfo businessInfo) {
        accountService.addNewBusiness(businessInfo);
    }


}
