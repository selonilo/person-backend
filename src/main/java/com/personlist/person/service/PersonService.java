package com.personlist.person.service;

import com.personlist.person.model.dto.PersonDto;
import com.personlist.person.model.dto.PersonSearch;
import com.personlist.person.model.entity.Person;
import com.personlist.person.model.mapper.PersonMapper;
import com.personlist.person.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public PersonDto save(PersonDto personDto) {
        Person person = PersonMapper.mapTo(personDto);
        personRepository.save(person);
        return personDto;
    }

    public Page<PersonDto> findPersonWithPagination(Pageable pageable, PersonSearch personSearch){
        if (personSearch.getAge() == null){
            personSearch.setAge("");
        }
        if (personSearch.getGender() == null){
            personSearch.setGender("");
        }
        if (personSearch.getEducationStatus() == null){
            personSearch.setEducationStatus("");
        }
        if (personSearch.getCity() == null){
            personSearch.setCity("");
        }
        if (personSearch.getDistrict() == null){
            personSearch.setDistrict("");
        }
        if (personSearch.getMilitaryStatus() == null){
            personSearch.setMilitaryStatus("");
        }
        Page<Person> person = personRepository.findAllPerson(personSearch.getAge(),personSearch.getGender(),personSearch.getEducationStatus(),
                personSearch.getCity(),personSearch.getDistrict(),personSearch.getMilitaryStatus(),pageable);
        return person.map(PersonMapper::mapTo);
    }
}
