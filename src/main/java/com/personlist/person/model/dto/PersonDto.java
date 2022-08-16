package com.personlist.person.model.dto;


import lombok.Data;

@Data
public class PersonDto {

    private Long id;
    private String nameSurname;
    private String gender;
    private String age;
    private String educationStatus;
    private String city;
    private String district;
    private String militaryStatus;
}
