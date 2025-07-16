package com.example.inventoryService.response;

import com.example.inventoryService.entity.Venue;
import lombok.*;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventInventoryResponse {

    private String event;
    private Long capacity;
    private Venue venue;

    // Additional fields can be added as needed
}

