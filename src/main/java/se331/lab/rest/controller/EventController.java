package se331.lab.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Event;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller


public class EventController {
    List<Event> eventList;



    @PostConstruct
    public void inti() {
        eventList = new ArrayList<>();
//      1
        eventList.add(Event.builder()
                .id(123L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .data("January 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("Kat Laydee")
                .build());
//      2
        eventList.add(Event.builder()
                .id(789L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .data("March 14, 2022")
                .time("10:00")
                .petAllowed(true)
                .organizer("Fern Pollin")
                .build());
//      3
        eventList.add(Event.builder()
                .id(789L)
                .category("sustainability")
                .title("Beach Cleanup")
                .description("Help pick up trash along the shore.")
                .location("Playa Del Carmen")
                .data("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .organizer("Carey Wales")
                .build());
//      4
        eventList.add(Event.builder()
                .id(1001L)
                .category("animal welfare")
                .title("Dog Adoption Day")
                .description("Find your new canine friend at this event.")
                .location("Woof Town")
                .data("August 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("Dawg Dahd")
                .build());
//        5
        eventList.add(Event.builder()
                .id(1002L)
                .category("food")
                .title("Canned Food Drive")
                .description("Bring your canned food to donate to those in need.")
                .location("Tin City")
                .data("September 14, 2022")
                .time("3:00")
                .petAllowed(true)
                .organizer("Kahn Opiner")
                .build());
//        6
        eventList.add(Event.builder()
                .id(1003L)
                .category("sustainability")
                .title("Highway Cleanup")
                .description("Help pick up trash along the highway.")
                .location("Highway 50")
                .data("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .organizer("Brody Kill")
                .build());
    }
    @GetMapping("events")
    public ResponseEntity<?> getEventlist(@RequestParam(value = "_limit",required = false)Integer perPage, @RequestParam(value = "_page", required = false)Integer page) {
        perPage = perPage == null?eventList.size():perPage;
        page = page == null?1:page;
        Integer firstIndex = (page-1)*perPage;
        List<Event> output = new ArrayList<>();
        try {
            for (int i = firstIndex; i < firstIndex + perPage; i++) {
                output.add(eventList.get(i));
            }
            return ResponseEntity.ok(output);
        } catch (IndexOutOfBoundsException ex) {
            return ResponseEntity.ok(output);
        }
    }

    @GetMapping("events/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Event output = null;
        for (Event event : eventList) {
            if (event.getId().equals(id)) {
                output = event;
                break;
            }
        }
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}
