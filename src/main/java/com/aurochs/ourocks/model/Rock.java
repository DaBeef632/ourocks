package com.aurochs.ourocks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Rock")
@Table(name = "rock")
public class Rock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,
            updatable = false,
            name = "rock_id")
    private Long rockId;
    private String name;
    private String email;
    private String streetAddress;
    private String city;
    private String phone;
    private String imageUrl;
    @OneToMany(
            mappedBy = "rock",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Beer> beers = new ArrayList<>();

    @Override
    public String toString(){
        return "Employee{" +
                "rockId=" + rockId +
                ", name ='" + name + '\'' +
                ", email='" + email + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
