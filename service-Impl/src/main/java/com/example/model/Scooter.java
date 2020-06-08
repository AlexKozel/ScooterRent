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
@Table(name = "Scooter")
public class Scooter  extends AbstractEntity{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer scooterId;

    @NonNull
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "rentPointId")
    private RentPoint rentPoint;

    @NonNull
    @OneToMany(mappedBy = "scooter")
    private List<RentStory> rentStoryList;

    private String model;
    @Enumerated(EnumType.ORDINAL)
    private ScooterStatus status;

    @Override
    public String toString() {
        return "Scooter{" +
                "model='" + model + '\'' +
                ", status=" + status +
                '}';
    }
}

