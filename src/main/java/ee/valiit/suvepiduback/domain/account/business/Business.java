package ee.valiit.suvepiduback.domain.account.business;

import ee.valiit.suvepiduback.domain.account.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "business", schema = "suvepidu")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 50)
    @NotNull
    @Column(name = "company_name", nullable = false, length = 50)
    private String companyName;

    @Size(max = 50)
    @NotNull
    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Size(max = 50)
    @NotNull
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Size(max = 50)
    @NotNull
    @Column(name = "registry_code", nullable = false, length = 50)
    private String registryCode;

    @Size(max = 50)
    @Column(name = "vat_number", length = 50)
    private String vatNumber;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

}