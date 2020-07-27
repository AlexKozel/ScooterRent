package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer rentStoryId;
    @NonNull
    private Integer rentDuration;
    @NonNull
    private Integer money;
    @NonNull
    private String paidWay;
    @ManyToOne( cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;
    @NonNull
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "scooterId")
    private Scooter scooter;

    @Override
    public String toString() {
        return "<br />" + "RentStory{" +
                "rentStoryId=" + rentStoryId +
                ", scooter=" + scooter +
                ", rentDuration=" + rentDuration +
                ", Money=" + money +
                ", paidWay='" + paidWay + '\'' +
                '}';
    }
}
