package com.example.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "LoginData")
public class LoginData  extends AbstractEntity{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int LoginId;
    @NonNull
    private String Login;
    @NonNull
    private String Password;

    @OneToOne
    @JoinColumn(name = "UserId")
    private User user;

    @Override
    public String toString() {
        return "LoginData{" +
                "LoginId=" + LoginId +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
