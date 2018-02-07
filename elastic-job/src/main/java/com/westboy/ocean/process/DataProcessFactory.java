package com.westboy.ocean.process;

/**
 * @author: wangpengbo
 * @date: 2018/2/5
 */
public class DataProcessFactory {

    private static DataProcess dataProcess = new DataProcess();

    public static DataProcess getDataProcess() {
        return dataProcess;
    }
}
