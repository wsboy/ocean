package com.westboy.ocean.factorypattern;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HistogramChart implements Chart {
    @Override
    public void display() {
        System.out.println("HistogramChart");
    }
}
