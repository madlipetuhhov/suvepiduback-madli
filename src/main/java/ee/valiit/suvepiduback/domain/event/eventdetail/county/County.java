package ee.valiit.suvepiduback.domain.event.eventdetail.county;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "county", schema = "suvepidu")
public class County {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "county", nullable = false, length = 50)
    private String county;

}