package ee.valiit.suvepiduback.summerevent.business;

import ee.valiit.suvepiduback.domain.account.business.Business;
import ee.valiit.suvepiduback.domain.account.business.BusinessMapper;
import ee.valiit.suvepiduback.domain.account.business.BusinessRepository;
import ee.valiit.suvepiduback.summerevent.business.dto.BusinessesDropdownInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final BusinessMapper businessMapper;
    public List<BusinessesDropdownInfo> executeBusinessesDropdown() {
        List<Business> businesses = businessRepository.findAll();
        return businessMapper.toBusinessesDropdownInfos(businesses);

    }
}
