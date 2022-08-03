package com.jy.sample.animal;

import lombok.Data;

@Data
public class Tiger implements Animal {
    @Override
    public String run() {
         return "호랑이가 뜁니다.";
    }
}
