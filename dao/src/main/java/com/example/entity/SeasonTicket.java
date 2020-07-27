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
@Table(name = "SeasonTicket")
public class SeasonTicket extends AbstractEntity{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer seasonTicketId;
    private Integer hoursLeft;
    private Integer costPerHour;

    @OneToOne
    @JoinColumn(name = "UserId")
    @NonNull
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "SeasonTicket{" +
                "HoursLeft=" + hoursLeft +
                ", CostPerHour=" + costPerHour +
                '}';
    }
}
