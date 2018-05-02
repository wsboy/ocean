package com.westboy.ocean.factorypattern;

public class ChartFactory {
    public static Chart getChart(ChartEnum type) {
        Chart chart;
        switch (type) {
            case PEI:
                chart = new PieChart();
                System.out.println("初始化设置柱状图！");
                break;
            case LINE:
                chart = new LineChart();
                System.out.println("初始化设置折线图！");
                break;
            case HISTOGRAM:
                chart = new HistogramChart();
                System.out.println("初始化设置饼状图");
                break;
            default:
                chart = null;
        }
        return chart;
    }
}
