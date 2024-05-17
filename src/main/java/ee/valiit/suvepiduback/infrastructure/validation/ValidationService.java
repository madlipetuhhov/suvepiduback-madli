package ee.valiit.suvepiduback.infrastructure.validation;

import ee.valiit.suvepiduback.domain.account.user.User;
import ee.valiit.suvepiduback.infrastructure.exception.ForbiddenException;

import java.util.Optional;

import static ee.valiit.suvepiduback.infrastructure.error.Error.INCORRECT_CREDENTIALS;
import static ee.valiit.suvepiduback.infrastructure.error.Error.LOCATION_UNAVAILABLE;

public class ValidationService {

    public static User getValidExistingUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new ForbiddenException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

//    public static void validateLocationExists(List<Location> locations) {
//        if (locations.isEmpty()) {
//            throw new DataNotFoundException(NO_LOCATION_FOUND.getMessage(), NO_LOCATION_FOUND.getErrorCode());
//        }
//    }

//    public static void validateLocationNameAvailable(boolean locationNameExists) {
//        if (locationNameExists) {
//            throw new ForbiddenException(LOCATION_UNAVAILABLE.getMessage(), LOCATION_UNAVAILABLE.getErrorCode());
//        }
//    }

}
