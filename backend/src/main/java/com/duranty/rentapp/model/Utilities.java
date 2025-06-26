package com.duranty.rentapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String brand;
    private String model;
    private int weight;
    private int volume;
    private String image;
    private boolean isElectric;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
