package com.example.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "RentPoint")
public class RentPoint extends AbstractEntity{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int RPointId;
    private String Coordinates;
    private String Address;
    private String Phone;
    private int CityId;

}
