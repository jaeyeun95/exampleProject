package com.jy.sample.animal;

import lombok.Data;

@Data
public class Person implements Animal {
    @Override
    public String run() {
        return "사람이 뜁니다";
    }
}
