package com.vanillabridge.lounge.Controller.Service;

import com.vanillabridge.lounge.Model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PointPolicy {
    public static final Integer postFee = 10;
    public static final Integer applyFee = 20;

    public boolean writePost(Person person) {
        return (person.getPersonPointAmount() >= postFee)? true : false;
    }

    public boolean application(Person person) {
        return (person.getPersonPointAmount() >= applyFee)? true : false;
    }
}
