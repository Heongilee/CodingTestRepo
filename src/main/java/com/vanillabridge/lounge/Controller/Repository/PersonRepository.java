package com.vanillabridge.lounge.Controller.Repository;

import com.vanillabridge.lounge.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
