package com.wesboy.ocean.demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author: wangpengbo
 * @date: 2018/2/6
 */
public class SimpleQuartzJob implements Job {

    public SimpleQuartzJob() {
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("In SimpleQuartzJob - executing its JOB at " + new Date() + " by " + context.getTrigger().getDescription());
    }
}
