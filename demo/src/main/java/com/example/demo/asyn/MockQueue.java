package com.example.demo.asyn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MockQueue {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    // 下单
    private String placeOrder;
    // 完成订单
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    @Async
    public void setPlaceOrder(String placeOrder) {
        new Thread(() -> {
            logger.info("接收到订单下单请求" + placeOrder);
            // 线程实际处理业务在这部分实现
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 此时业务处理完成，订单任务完成
            this.completeOrder = placeOrder;
            logger.info("下单请求已完成" + placeOrder);
        }).start();
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
