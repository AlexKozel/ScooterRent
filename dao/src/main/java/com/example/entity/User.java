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
@Table(name = "User")
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer userId;
    @NonNull
    private String firstName;
    @NonNull
    private String secondName;

    @OneToOne(targetEntity = Discount.class)
    @JoinColumn(name = "DiscountId")
    private Discount discount;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "LoginId")
    @NonNull
    private LoginData loginData;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<RentStory> rentStoryList;

    @OneToOne(mappedBy = "user",orphanRemoval = true)
    private SeasonTicket seasonTicket;

    /**
     * TODO
     * don't forget remove <br />
     */
    @Override
    public String toString() {
        return "User{" +
                "UserId=" + userId +
                ", FirstName='" + firstName + '\'' + "<br />" +
                ", SecondName='" + secondName + '\'' + "<br />" +
                ", Discount=" + discount +'\'' + "<br />" +
                ", LoginData=" + loginData  +'\'' + "<br />" +
//                ", RentStories=" + rentStoryList +'\'' + "<br />" +
                '}';
    }
}
