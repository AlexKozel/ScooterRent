package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

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
    private int loginId;
    @NonNull
    private String login;
    @NonNull
    private String password;

    @OneToOne(mappedBy = "discount",cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "LoginRole",
                joinColumns = @JoinColumn(name = "LoginId"),
                inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private List<Role> roles;

    @Override
    public String toString() {
        return "LoginData{" +
                "LoginId=" + loginId +
                ", Login='" + login + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
