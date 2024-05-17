package ee.valiit.suvepiduback.domain.event.mainevent;

import ee.valiit.suvepiduback.domain.account.business.Business;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "main_event", schema = "suvepidu")
public class MainEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @Size(max = 50)
    @NotNull
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Size(max = 255)
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "image_data", nullable = false)
    private byte[] imageData;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;


}