package ee.valiit.suvepiduback.summerevent.mainevent;

import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfo;
import ee.valiit.suvepiduback.summerevent.mainevent.dto.MainEventInfoExtended;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class MainEventController {
    private final MainEventService mainEventService;

    @PostMapping("/event/main")
    @Operation(summary = "Uue sündmuse lisamine. Tagastab mainEventId ",
            description = "Süsteemi lisatakse uus sündmus koos title, description ja imageData'ga.")
    public Integer addNewMainEvent(@RequestParam Integer businessId, @RequestBody MainEventInfo mainEventInfo) {
        // siin nt NewMainEventInfo DTO ilma ID-ta
//        tagastab mainEventId, et navigeerida frondis featureCategoryRoutile
        return mainEventService.addNewMainEvent(businessId, mainEventInfo);
    }

    // siin tagastad DTO objekti, millel on ID küljes
    @GetMapping("/event/main")
    @Operation(summary = "Ühe sündmuse toomine andmebaasist.",
            description = "Andmebaasist tuuakse üks sündmus mainEventId abil, kui selle staatus on aktiivne.")
    public MainEventInfoExtended getMainEvent(@RequestParam Integer mainEventId) {
        // get MainEventInfo object by ID
        // add new method in service to get data
        // in mainEventService.getMainEvent add relevant repository code
        return mainEventService.getMainEvent(mainEventId);
    }

    // siin tagastad DTO objekti listi objektidest, millel on ID-d küljes
    @GetMapping("/events/main")
    @Operation(summary = "Kõikide sündmuste toomine andmebaasist vastava ettevõtte (businessId) kohta.",
            description = "Andmebaasist tuuakse vastava ettevõtte kõik aktiivse staatusega sündmused businessId abil.")
    public List<MainEventInfoExtended> getMainEvents(@RequestParam Integer businessId) {
        // get list of MainEventInfo objects by business ID to only show relevant events
        // add new method in service to get data
        // in mainEventService.getMainEvents add relevant repository code
        return mainEventService.getMainEvents(businessId);
    }

    // siin tagastad uuendatud DTO objekti , millel on ID küljes (UPD:  bank33back pealt vaadates, et ei pea tagastama)
    @PutMapping("/event/main")
    @Operation(summary = "Olemasoleva sündmuse andmete muutmine mainEventId abil.",
            description = "Andmebaasis kirjutatakse üle olemasoleva sündmuse andmed.")
    public void editMainEvent(@RequestBody MainEventInfoExtended mainEventInfoExtended) {
        // siin nt UpdateMainEventInfo DTO koos ID-ga
        // update MainEventInfo object
        // add new method in service to update data
        // in mainEventService.updateMainEvent add relevant repository code
        mainEventService.editMainEvent(mainEventInfoExtended);
    }

    // siin tagastad kustutatud objekti ID, aga ainult selleks, et kontrollida frontendis kas see õnnestus
    @DeleteMapping("/event/main")
    @Operation(summary = "Olemasoleva sündmuse eemaldamine mainEventId abil.",
            description = "Andmebaasist reaalselt sündmust ei eemaldata, vaid deaktiveeritakse.")
    public Integer removeMainEvent(@RequestParam Integer mainEventId) {
        // delete MainEventInfo by ID
        // add new method in service to delete data
        // in mainEventService.deleteMainEvent add relevant repository code
        return mainEventService.removeMainEvent(mainEventId);
    }
}
