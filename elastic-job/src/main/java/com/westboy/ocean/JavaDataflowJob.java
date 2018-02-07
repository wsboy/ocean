package com.westboy.ocean;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.westboy.ocean.entity.Foo;
import com.westboy.ocean.process.DataProcess;
import com.westboy.ocean.process.DataProcessFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: wangpengbo
 * @date: 2018/2/5
 */
public class JavaDataflowJob implements DataflowJob<Foo> {

    private DataProcess dataProcess = DataProcessFactory.getDataProcess();

    @Override
    public List<Foo> fetchData(ShardingContext shardingContext) {

        List<Foo> result = dataProcess.getData(shardingContext.getShardingParameter(), shardingContext.getShardingTotalCount());

        System.out.println(String.format("Thread ID: %s, Date: %s, Sharding Context: %s, Action: %s, Data: %s",
                Thread.currentThread().getId(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
                shardingContext,
                "fetch data",
                result));
        return result;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<Foo> data) {
        for (Foo foo : data) {
            dataProcess.setData(foo.getId());
        }

        System.out.println(String.format("Thread ID: %s, Date: %s, Sharding Context: %s, Action: %s, Data: %s",
                Thread.currentThread().getId(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
                shardingContext,
                "finish data",
                data));
    }
}
