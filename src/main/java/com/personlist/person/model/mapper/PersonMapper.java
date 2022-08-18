package com.personlist.person.model.mapper;

import com.personlist.person.model.dto.PersonDto;
import com.personlist.person.model.entity.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class PersonMapper {

    public static PersonDto mapTo(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setNameSurname(person.getNameSurname());
        personDto.setGender(person.getGender());
        personDto.setAge(person.getAge());
        personDto.setEducationStatus(person.getEducationStatus());
        personDto.setCity(person.getCity());
        personDto.setDistrict(person.getDistrict());
        personDto.setMilitaryStatus(person.getMilitaryStatus());
        return personDto;
    }

    public static Person mapTo(PersonDto personDto){
        Person person = new Person();
        person.setId(personDto.getId());
        person.setNameSurname(personDto.getNameSurname());
        person.setGender(personDto.getGender());
        person.setAge(personDto.getAge());
        person.setEducationStatus(personDto.getEducationStatus());
        person.setCity(personDto.getCity());
        person.setDistrict(personDto.getDistrict());
        person.setMilitaryStatus(personDto.getMilitaryStatus());
        return person;
    }

    public static Person updatePerson(Person entity, PersonDto dto){
        entity.setId(dto.getId());
        entity.setNameSurname(dto.getNameSurname());
        entity.setGender(dto.getGender());
        entity.setAge(dto.getAge());
        entity.setEducationStatus(dto.getEducationStatus());
        entity.setCity(dto.getCity());
        entity.setDistrict(dto.getDistrict());
        entity.setMilitaryStatus(dto.getMilitaryStatus());
        return entity;
    }

    public static List<PersonDto> mapToList(List<Person> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(PersonMapper::mapTo).collect(Collectors.toList());
    }
}
