package com.wesboy.ocean.quartz;

import com.wesboy.ocean.DateUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author: wangpengbo
 * @date: 2018/2/8
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss") + ": doing something...");
    }
}
