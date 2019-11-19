package com.mngr.adminapp.adminapp;

import com.mngr.adminapp.adminapp.model.Event;
import com.mngr.adminapp.adminapp.model.Group;
import com.mngr.adminapp.adminapp.model.GroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Neversea - Constanta", "Electric Castle - Cluj Napoca", "After Hills - Iasi",
                "Hawaiian Party - Constanta").forEach(name -> repository.save(new Group(name))
        );

        Group events = repository.findByName("Neversea - Constanta");
        Event e = Event.builder().title("Party by the sea")
                .description("Festival multigenre 2-5 Iulie")
                .date(Instant.parse("2020-07-02T18:00:00.000Z"))
                .build();
        events.setEvents(Collections.singleton(e));
        repository.save(events);

        repository.findAll().forEach(System.out::println);
    }
}
