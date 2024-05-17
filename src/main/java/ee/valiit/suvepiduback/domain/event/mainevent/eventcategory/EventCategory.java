package ee.valiit.suvepiduback.domain.event.mainevent.eventcategory;

import ee.valiit.suvepiduback.domain.event.mainevent.eventcategory.category.Category;
import ee.valiit.suvepiduback.domain.event.mainevent.MainEvent;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "event_category", schema = "suvepidu")
public class EventCategory {
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
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}