package se331.lab.rest.dao;

import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;
    @PostConstruct
    public void inti() {
        organizerList = new ArrayList<>();
//      1
        organizerList.add(Organizer.builder()
                .id(11L)
                .name("Oliver Lee")
                .address("Woof Town")
                .build());
//      2
        organizerList.add(Organizer.builder()
                .id(12L)
                .name("Jack Tremblay")
                .address("Tin City")
                .build());
//      3
        organizerList.add(Organizer.builder()
                .id(13L)
                .name("Harry Gelbero")
                .address("Woof Town")
                .build());
//      4
        organizerList.add(Organizer.builder()
                .id(14L)
                .name("Jacob Martin")
                .address("Flora City")
                .build());
//        5
        organizerList.add(Organizer.builder()
                .id(15L)
                .name("Charlie Lam")
                .address("Playa Del Carmen")
                .build());
//        6
        organizerList.add(Organizer.builder()
                .id(16L)
                .name("Thomas Smith")
                .address("Tin City")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page-1) * pageSize;
        return organizerList.subList(firstIndex, firstIndex+pageSize);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(event -> event.getId().equals(id)).findFirst().orElse(null);
    }
}
