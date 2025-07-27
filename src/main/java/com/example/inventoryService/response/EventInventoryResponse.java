package com.example.inventoryService.response;

import com.example.inventoryService.entity.Venue;
import lombok.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventInventoryResponse {
    private Long eventId;
    private String event;
    private Long capacity;
    private Venue venue;
    private BigDecimal ticketPrice;

    // Additional fields can be added as needed
}

