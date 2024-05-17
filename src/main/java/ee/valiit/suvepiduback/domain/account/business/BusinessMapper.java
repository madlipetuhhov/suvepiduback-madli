package ee.valiit.suvepiduback.domain.account.business;

import ee.valiit.suvepiduback.summerevent.Status;
import ee.valiit.suvepiduback.summerevent.account.dto.BusinessInfo;
import ee.valiit.suvepiduback.summerevent.business.dto.BusinessesDropdownInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BusinessMapper {

    @Mapping(source = "companyName", target = "companyName")
    @Mapping(source = "registryCode", target = "registryCode")
    @Mapping(source = "vatNumber", target = "vatNumber")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "email", target = "email")
    @Mapping(constant = Status.ACTIVE, target = "status")
    Business toBusiness(BusinessInfo businessInfo);

    @Mapping(source = "id", target = "businessId")
    @Mapping(source = "companyName", target = "companyName")
    BusinessesDropdownInfo toBusinessesDropdownInfo(Business business);

    List<BusinessesDropdownInfo> toBusinessesDropdownInfos(List<Business> businesses);
}