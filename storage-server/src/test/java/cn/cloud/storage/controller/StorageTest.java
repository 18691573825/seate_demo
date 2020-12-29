package cn.cloud.storage.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.http.HttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author LLT
 * @Description: 单元测试
 * @date: 2020/5/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageTest {



    /**
     * 并行提交任务
     *
     * @throws Exception
     */
    @Test
    public void testArrayListConcuurent() throws Exception {
        // 可重用的固定线程池
        List<Callable<String>> callables = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10; i++) {
            callables.add(getTask(i));
        }
        // submit.get()有阻塞作用,当线程结束后,获取到线程内容,主线程才会去运行一个任务
        TimeInterval timer = DateUtil.timer();
        List<Future<String>> futures = fixedThreadPool.invokeAll(callables);// 同时处理多条任务,一并返回
        for (Future<String> future : futures) {
            stringList.add(future.get());
        }
        System.out.println(timer.intervalSecond());
        System.out.println("end");
    }

    public Callable getTask(Integer integer) {
        Callable<String> callable = new Callable() {
            @Override
            public String call() throws Exception {

                String url = "https://play.yunxi.tv/pages/6205627f3948444a9ec87ee567f94005?openId=543254325435-hcQWU#/\n";
                Map<String, Object> map = new HashMap<>();
                map.put("token", "M2FmMDFhYzY0ZDc2NDk3OTk5MDdlZGVhZmQ1ZjliYjg%253D");
                //Object post = HttpUtil.post(url, map);
                Object s = HttpUtil.get(url);
                return Thread.currentThread().getName() + "我是你哥哥" + integer;
            }
        };
        return callable;
    }
}
