package ee.valiit.suvepiduback.summerevent.login;

import ee.valiit.suvepiduback.infrastructure.error.ApiError;
import ee.valiit.suvepiduback.summerevent.login.dto.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Login. Returns userId and roleName.",
            description = """
                    The system searches for a user whose account is also active using username and password.
                    If no match is found, an error with errorCode 111""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Invalid username or password",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        return loginService.login(username, password);
    }
}
