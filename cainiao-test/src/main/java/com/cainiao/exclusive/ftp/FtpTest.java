package com.cainiao.exclusive.ftp;

import org.slf4j.MDC;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by wangkecheng on 2018/7/31.
 */
public class FtpTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        List<Future<String>> futureList = new ArrayList<Future<String>>();

        for(int i = 0; i < 3 ; i++){
            futureList.add(executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    String ip = "127.0.0.1";
                    int port = 21;
                    String username = "wangkecheng";
                    String password = "wangkecheng";
                    String serverpath = "F:\\ftp\\upload";
                    String fileName = "test.txt";
                    String localPath = "F:\\ftp\\download";
                    String str = FtpUtil.downFileById(ip,port,username,password,serverpath,fileName,localPath);
                    System.out.println(str);
                    return str;
                }
            }));
        }
        if (futureList.isEmpty()) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        for (Future<String> future : futureList) {
            while (true) {
                if (future.isDone()) {
                    break;
                }
            }
        }
    }
}
