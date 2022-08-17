package com.personlist.person.controller;

import com.personlist.person.model.dto.PersonDto;
import com.personlist.person.model.dto.PersonSearch;
import com.personlist.person.service.PersonService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController extends BaseController{

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping(PUBLIC_SAVE_PERSON)
    public ResponseEntity<PersonDto> save(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(personService.save(personDto));
    }

    @PostMapping(PUBLIC_FIND_ALL_PERSONS)
    public ResponseEntity getWorkersWithSort(Pageable pageable, @RequestBody PersonSearch personSearch){
        return ResponseEntity.ok(personService.findPersonWithPagination(pageable,personSearch));
    }
}
