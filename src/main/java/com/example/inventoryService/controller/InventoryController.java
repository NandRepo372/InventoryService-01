package com.example.inventoryService.controller;

import com.example.inventoryService.response.EventInventoryResponse;
import com.example.inventoryService.response.VenueInventoryResponse;
import com.example.inventoryService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;

    }

    @GetMapping("/inventory/events")
    public @ResponseBody List<EventInventoryResponse> inventoryGetAllEvents(){
            return inventoryService.getAllEvents();
    }

    @GetMapping("/inventory/event/{eventId}")
    public @ResponseBody EventInventoryResponse inventoryGetEvent(@PathVariable("eventId") Long eventId){
        return inventoryService.getEventById(eventId);
    }


    @GetMapping("/inventory/venue/{venueId}")
    public @ResponseBody VenueInventoryResponse inventoryGetVenueById(@PathVariable("venueId") Long venueId) {
        return inventoryService.getVenueInformation(venueId);
    }

    @PutMapping("/inventory/event/{eventId}/capacity/{capacity}")
    public @ResponseBody EventInventoryResponse updateEventCapacity(@PathVariable("eventId") Long eventId, @PathVariable("capacity") Long capacity) {
        return inventoryService.updateEventCapacity(eventId, capacity);
    }
}
