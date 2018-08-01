package com.cainiao.exclusive.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * Created by wangkecheng on 2018/7/27.
 */
public class TestTask implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(shardingContext.toString());
        switch (shardingContext.getShardingItem()){
            case 0:
                System.out.println("分片一");
                break;
            case 1:
                System.out.println("分片二");
                break;
        }
    }
}
