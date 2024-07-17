package ee.valiit.suvepiduback.summerevent.account;

import ee.valiit.suvepiduback.domain.account.business.Business;
import ee.valiit.suvepiduback.summerevent.business.dto.BusinessInfo;
import ee.valiit.suvepiduback.domain.account.business.BusinessMapper;
import ee.valiit.suvepiduback.domain.account.business.BusinessRepository;
import ee.valiit.suvepiduback.domain.account.user.User;
import ee.valiit.suvepiduback.domain.account.user.UserMapper;
import ee.valiit.suvepiduback.domain.account.user.UserRepository;
import ee.valiit.suvepiduback.summerevent.account.dto.UserInfo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {
    private final UserRepository userRepository;
    private final BusinessRepository businessRepository;

    private final UserMapper userMapper;
    private final BusinessMapper businessMapper;

    public void addNewUser(UserInfo userInfo) {
        createAndSaveUser(userInfo);
    }

    @Transactional
    public void addNewBusiness(BusinessInfo businessInfo) {
        User user = createAndSaveUser(businessInfo);
        Business business = businessMapper.toBusiness(businessInfo);
        business.setUser(user);
        businessRepository.save(business);
    }

    private User createAndSaveUser(UserInfo userInfo) {
        User user = userMapper.toUser(userInfo);
        userRepository.save(user);
        return user;
    }
}
