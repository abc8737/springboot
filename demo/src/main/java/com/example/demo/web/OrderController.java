package com.example.demo.web;

import com.example.demo.asyn.DeferredResultHolder;
import com.example.demo.asyn.MockQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * 订单页面实现
 * 实现多线程异步处理任务
 * 使用了Callable多线程异步执行返回结果，Thread线程异步执行，ApplicationListener监听器
 */
@RestController
@Slf4j
public class OrderController {

    // 等价于@Slf4j的注解
//    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    @RequestMapping(value = "/singleRun")
    public String testThread() throws InterruptedException {
        log.info("主线程开始运行");
        Thread.sleep(1000);
        log.info("主线程结束运行");

        return "success";
    }

    @RequestMapping(value = "/orderAsync")
    public Callable orderAsync() {
        log.info("主线程开始");
        Callable result = new Callable() {
            @Override
            public Object call() throws Exception {
                log.info("副线程开始");
                Thread.sleep(1000);
                log.info("副线程返回");
                return "success";
            }
        };
        log.info("主线程返回");
        return result;
    }

    @RequestMapping(value = "/orderMockQueue")
    public DeferredResult orderQueue() {
        log.info("orderMockQueue主线程开始");
        // 随机当前时间15位字符串
        String orderNum = sdf.format(new Date());
        mockQueue.setPlaceOrder(orderNum);

        DeferredResult deferredResult = new DeferredResult();
        deferredResultHolder.getMap().put(orderNum, deferredResult);
        // 休眠1s
        log.info("orderMockQueue主线程结束");

        return deferredResult;
    }

}
