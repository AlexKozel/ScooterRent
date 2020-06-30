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
@Table(name = "RentPoint")
public class RentPoint extends AbstractEntity{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer rentPointId;
    @NonNull
    private String coordinates;
    @NonNull
    private String address;
    @NonNull
    private String phone;

    @OneToMany(mappedBy = "rentPoint", cascade = CascadeType.ALL)
    private List<Scooter> scooterList;

    @NonNull
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "cityId")
    private City city;

    @Override
    public String toString() {
        return "RentPoint{" +
                "Coordinates='" + coordinates + '\'' +
                ", Address='" + address + '\'' +
                ", Phone='" + phone + '\'' +
                '}';
    }
}
