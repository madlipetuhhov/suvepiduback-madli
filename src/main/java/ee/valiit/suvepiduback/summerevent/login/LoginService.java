package ee.valiit.suvepiduback.summerevent.login;

import ee.valiit.suvepiduback.domain.account.user.User;
import ee.valiit.suvepiduback.domain.account.user.UserMapper;
import ee.valiit.suvepiduback.domain.account.user.UserRepository;
import ee.valiit.suvepiduback.infrastructure.validation.ValidationService;
import ee.valiit.suvepiduback.summerevent.Status;
import ee.valiit.suvepiduback.summerevent.login.dto.LoginResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;



    public LoginResponse login(String username, String password) {
        Optional<User> optionalUser = userRepository.findOptionalUserBy(username, password, Status.ACTIVE);
        return userMapper.toLoginResponse(ValidationService.getValidExistingUser(optionalUser));
    }


}
