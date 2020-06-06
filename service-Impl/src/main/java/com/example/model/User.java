package com.example.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "User")
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int UserId;
    private String FirstName;
    private String SecondName;
    private Boolean Role;

    @OneToOne
    @JoinColumn(name = "DiscountId", referencedColumnName = "DiscountId")
    private Discount discount;

    //    private LoginData loginData;
//    private List<RentStory> rentStoryList;
    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", FirstName='" + FirstName + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", Role=" + Role +'\'' +
                ", Discount =" + discount +
                '}';
    }

}
