package com.example.stage4e.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "_user")
public class User implements UserDetails {

        @Id
        @GeneratedValue
        private Integer UserId;
        private String firstname;
        private String lastname;
        @Temporal(TemporalType.DATE)
        private Date birthDate;
        private String email;
        private String password;
        private String cin;
        private String telephone;
        private String address;
        @Enumerated(EnumType.STRING)
        private Role role;
        private Boolean locked=false;
        private Boolean enabled=false;
        private String code;



        @JsonIgnore
        @OneToMany(mappedBy = "user")
        private List<Token> tokens;






    @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority(role.name()));
        }



        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return email;
        }



        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return false;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return false;
        }

        @Override
        public boolean isEnabled() {
            return false;
        }



    public boolean getEnabled() {
            return false;
    }

        public User(String firstname, String lastname, String email, String password, Role role) {
                this.firstname = firstname;
                this.lastname = lastname;
                this.email = email;
                this.password = password;
                this.role = role;
        }

        @Override
        public String toString() {
                return "User{" +
                        "id=" + UserId +
                        ", firstname='" + firstname + '\'' +
                        ", lastname='" + lastname + '\'' +
                        ", role=" + role +
                        '}';
        }


    @OneToMany(cascade= CascadeType.ALL, mappedBy = "publierPar")
    List<Annonce> listOfAnnonce;

    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;
}


