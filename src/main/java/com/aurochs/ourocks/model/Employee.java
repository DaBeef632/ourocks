package com.aurochs.ourocks.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl; //hold the location to show the file
    @Column(nullable = false, updatable = false)
    private String employeeCode;

    @Override
    public String toString(){
        return "Employee{" +
                "id=" + id +
                ", name ='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
