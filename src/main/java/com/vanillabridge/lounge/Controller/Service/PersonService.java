package com.vanillabridge.lounge.Controller.Service;

import com.vanillabridge.lounge.Controller.Repository.PersonRepository;
import com.vanillabridge.lounge.Model.Person;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    // application for participation
    public JSONObject apply(Integer count, JSONObject reqBody) {
        Long myId = Long.valueOf((Integer) reqBody.get("personId"));
        Person personDto = personRepository.findById(myId).orElse(null);

        return null;
    }
}
