package com.example.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "RentPoint")
public class RentPoint extends AbstractEntity{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer RentPointId;
    @NonNull
    private String Coordinates;
    @NonNull
    private String Address;
    @NonNull
    private String Phone;

    @OneToMany(mappedBy = "rentPoint")
    private List<Scooter> scooterList;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "cityId")
    private City city;

    @Override
    public String toString() {
        return "RentPoint{" +
                "Coordinates='" + Coordinates + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}
