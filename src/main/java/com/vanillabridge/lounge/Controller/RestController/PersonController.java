package com.vanillabridge.lounge.Controller.RestController;

import com.vanillabridge.lounge.Controller.Service.PersonService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PutMapping("/application")
    JSONObject apply(@RequestParam Integer count, @RequestBody JSONObject reqBody) {
        return personService.apply(count, reqBody);
    }
}
