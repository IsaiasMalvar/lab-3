package com.name.carregistry.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class Vehicle {

    private String brand;
    private String model;
    private Integer year;

}
