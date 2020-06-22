package com.example.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "RentStory")
public class RentStory extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int rentStoryId;

    @NonNull
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;
    @NonNull
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "scooterId")
    private Scooter scooter;
    @NonNull
    private Integer rentDuration;
    @NonNull
    private Integer Money;
    @NonNull
    private String paidWay;

    @Override
    public String toString() {
        return "<br />" + "RentStory{" +
                "rentStoryId=" + rentStoryId +
                ", scooter=" + scooter +
                ", rentDuration=" + rentDuration +
                ", Money=" + Money +
                ", paidWay='" + paidWay + '\'' +
                '}';
    }
}
