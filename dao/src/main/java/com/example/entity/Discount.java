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
@Table(name = "Discount")
public class Discount extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer discountId;

    @NonNull
    private Integer discountRate;

    @OneToOne(mappedBy = "discount")
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "Discount{" +
                "DiscountId=" + getDiscountId() +
                ", DiscountRate=" + discountRate +
                '}';
    }
}