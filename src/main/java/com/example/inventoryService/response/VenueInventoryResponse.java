package com.example.inventoryService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VenueInventoryResponse {
    private Long Id;
    private String name;
    private Long totalCapacity;

    // Additional fields can be added as needed
}
