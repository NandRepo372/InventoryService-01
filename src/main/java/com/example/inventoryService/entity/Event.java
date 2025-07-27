package com.example.inventoryService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "event")
public class Event {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "totoal_capacity")
    private Long totoal_capacity;

    @Column(name = "left_capacity")
    private Long left_capacity;

    @Column(name = "ticket_price")
    private BigDecimal ticket_price;

    @ManyToOne
    @JoinColumn(name = "venue_id", referencedColumnName = "id")
    private Venue venue;

}
