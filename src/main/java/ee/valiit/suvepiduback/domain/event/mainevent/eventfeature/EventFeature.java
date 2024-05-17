package ee.valiit.suvepiduback.domain.event.mainevent.eventfeature;

import ee.valiit.suvepiduback.domain.event.mainevent.eventfeature.feature.Feature;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "event_feature", schema = "suvepidu")
public class EventFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "main_event_id", nullable = false)
    private MainEvent mainEvent;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "feature_id", nullable = false)
    private Feature feature;

}