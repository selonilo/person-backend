package com.personlist.person.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "worker")
public class Person {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_surname")
    private String nameSurname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private String age;

    @Column(name = "education_status")
    private String educationStatus;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "military_status")
    private String militaryStatus;


}
