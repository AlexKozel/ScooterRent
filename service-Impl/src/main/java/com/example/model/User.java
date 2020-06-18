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
@Table(name = "User")
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer UserId;
    @NonNull
    private String FirstName;
    @NonNull
    private String SecondName;
    @NonNull
    private Boolean Role;

    @OneToOne
    @JoinColumn(name = "DiscountId")
    private Discount discount;

    @OneToOne(mappedBy = "user", orphanRemoval = true)
    @NonNull
    private LoginData loginData;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<RentStory> rentStoryList;

    @OneToOne(mappedBy = "user")
    private SeasonTicket seasonTicket;

    /**
     * TODO
     * don't forget remove <br />
     */
    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", FirstName='" + FirstName + '\'' + "<br />" +
                ", SecondName='" + SecondName + '\'' + "<br />" +
                ", Role=" + Role +'\'' + "<br />" +
                ", Discount=" + discount +'\'' + "<br />" +
                ", LoginData=" + loginData  +'\'' + "<br />" +
                ", RentStories=" + rentStoryList +'\'' + "<br />" +
                '}';
    }

}
