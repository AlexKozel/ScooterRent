package com.example.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "SeasonTicket")
public class SeasonTicket extends AbstractEntity{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int SeasonTicketId;
    private int HoursLeft;
    private int CostPerHour;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private int UserId;
}
