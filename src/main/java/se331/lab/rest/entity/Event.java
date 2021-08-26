package se331.lab.rest.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Event {
    Long id;
    String category;
    String title;
    String description;
    String location;
    String data;
    String time;
    boolean petAllowed;
    String organizer;
}
