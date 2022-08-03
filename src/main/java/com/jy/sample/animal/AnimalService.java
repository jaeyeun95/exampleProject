package com.jy.sample.animal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AnimalService {

    public String callAnimal(String kind) {
        if (kind.equals("animal")) {
            Tiger tiger = new Tiger();
            return tiger.run();
        } else {
            Person person = new Person();
            return person.run();
        }


    }
}
