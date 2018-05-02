package com.westboy.ocean.factorypattern;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LineChart implements Chart {
    @Override
    public void display() {
        System.out.println("LineChart");
    }
}
