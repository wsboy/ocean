package com.westboy.ocean.factorypattern;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PieChart implements Chart {
    @Override
    public void display() {
        System.out.println("PieChart");
    }
}
