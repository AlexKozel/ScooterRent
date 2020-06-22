package com.example.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "City")
public class City extends AbstractEntity{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer CityId;

    @NonNull
    private String CityName;

    @OneToMany(mappedBy = "city")
    private List<RentPoint> rentPointList;

    @Override
    public String toString() {
        return "City{" +
                "CityName='" + CityName + '\'' +
                '}';
    }
}
