package com.example.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Discount")
public class Discount extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer DiscountId;

    @NonNull
    private Integer DiscountRate;

    @OneToOne(mappedBy = "discount")
    private User user;

    @Override
    public String toString() {
        return "Discount{" +
                "DiscountId=" + DiscountId +
                ", DiscountRate=" + DiscountRate +
                '}';
    }
}
