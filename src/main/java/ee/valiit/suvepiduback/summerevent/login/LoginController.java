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
    @Operation(summary = "Sisse logimine. Tagastab userId ja roleName",
            description = """
                    Süsteemist otsitakse username ja password abil kasutajat, kelle konto on ka aktiivne. 
                    Kui vastet ei leita vistakse viga errorCode'ga 111""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " meie OK"),
            @ApiResponse(responseCode = "403", description = "Vale kasutajanimi või parool",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })

    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        LoginResponse loginResponse = loginService.login(username, password);
        return loginResponse;
    }

}
