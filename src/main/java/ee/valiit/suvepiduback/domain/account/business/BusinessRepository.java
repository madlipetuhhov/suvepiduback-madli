package ee.valiit.suvepiduback.domain.account.business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Integer> {


    @Query("select b from Business b where b.user.id = :userId order by b.companyName")
    List<Business> findBusinessesBy(Integer userId);
}