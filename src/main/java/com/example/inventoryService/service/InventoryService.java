package com.example.inventoryService.service;

import com.example.inventoryService.entity.Event;
import com.example.inventoryService.entity.Venue;
import com.example.inventoryService.repository.EventRepository;
import com.example.inventoryService.repository.VenueRepository;
import com.example.inventoryService.response.EventInventoryResponse;
import com.example.inventoryService.response.VenueInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;

    @Autowired
    public InventoryService(EventRepository eventRepository, VenueRepository venueRepository) {
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
    }
    public List<EventInventoryResponse> getAllEvents() {
        final List<Event> events = eventRepository.findAll();

        return events.stream()
                .map(event -> EventInventoryResponse.builder()
                        .event(event.getName())
                        .capacity(event.getTotoal_capacity())
                        .venue(event.getVenue())
                        .build())
                .toList();
    }

    public VenueInventoryResponse getVenueInformation(Long venueId) {
        final Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new RuntimeException("Venue not found"));

        return VenueInventoryResponse.builder()
                .Id(venue.getId())
                .name(venue.getName())
                .totalCapacity(venue.getTotal_capacity())
                .build();

    }

    public EventInventoryResponse getEventById(Long eventId ) {
        final Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));

        return EventInventoryResponse.builder()
                .eventId(event.getId())
                .event(event.getName())
                .capacity(event.getLeft_capacity())
                .venue(event.getVenue())
                .ticketPrice(event.getTicket_price())
                .build();
    }

    public EventInventoryResponse updateEventCapacity(Long eventId, Long capacity) {
        final Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        if (capacity < 0 || capacity > event.getTotoal_capacity()) {
            throw new IllegalArgumentException("Invalid capacity value");
        }

        event.setLeft_capacity(event.getLeft_capacity() - capacity);
        eventRepository.saveAndFlush(event);

        return EventInventoryResponse.builder()
                .eventId(event.getId())
                .event(event.getName())
                .capacity(event.getLeft_capacity())
                .venue(event.getVenue())
                .ticketPrice(event.getTicket_price())
                .build();
    }
}
