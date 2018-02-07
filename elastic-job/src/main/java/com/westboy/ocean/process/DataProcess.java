package com.westboy.ocean.process;

import com.westboy.ocean.entity.Foo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: wangpengbo
 * @date: 2018/2/5
 */
public class DataProcess {

    private Map<Integer, Foo> data = new ConcurrentHashMap<>(30, 1);

    DataProcess() {
        for (int i = 0; i < 30; i++) {
            data.put(i, new Foo(i, Foo.Status.TODO));
        }
    }

    public List<Foo> getData(String tailId, int shardNum) {
        int intId = Integer.parseInt(tailId);
        List<Foo> result = new ArrayList<>();
        for (Map.Entry<Integer, Foo> each : data.entrySet()) {
            Foo foo = each.getValue();
            int key = each.getKey();

            //分片1：0、3、6、9 ...
            //分片2：1、4、7、10 ...
            //分片3：2、5、8、11 ...
            if (key % shardNum == intId && foo.getStatus() == Foo.Status.TODO) {
                result.add(foo);
            }
        }
        return result;
    }

    public void setData(int i) {
        data.get(i).setStatus(Foo.Status.DONE);
    }

}
