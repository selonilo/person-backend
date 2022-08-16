package com.personlist.person.repository;

import com.personlist.person.model.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person,Long> {
    
    @Query("SELECT p FROM Person p WHERE (:age = '' or upper_tr(p.age) like upper_tr(concat('%',:age,'%'))) " +
            "and (:gender = '' or upper_tr(p.gender) like upper_tr(concat('%',:gender,'%')))" +
            "and (:educationStatus = '' or upper_tr(p.educationStatus) like upper_tr(concat('%',:educationStatus,'%')))" +
            "and (:city = '' or upper_tr(p.city) like upper_tr(concat('%',:city,'%')))" +
            "and (:district = '' or upper_tr(p.district) like upper_tr(concat('%',:district,'%')))" +
            "and (:militaryStatus = '' or upper_tr(p.militaryStatus) like upper_tr(concat('%',:militaryStatus,'%')))")
    Page<Person> findAll(String age, String gender,String educationStatus,String city,String district,String militaryStatus, Pageable pageable);

}
