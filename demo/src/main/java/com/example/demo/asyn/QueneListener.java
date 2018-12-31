package com.example.demo.asyn;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 监听器，监控订单状态
 */
@Component
@Slf4j
public class QueneListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Lambda表达式实现启动线程
        new Thread(() -> {
            while (true) {
                if (StringUtils.isNotBlank(mockQueue.getCompleteOrder())) {
                    String order = mockQueue.getCompleteOrder();
                    deferredResultHolder.getMap().get(order).setResult(mockQueue.getCompleteOrder() + "订单下单成功");
                    log.info("返回订单完成结果");
                    // 置空completeOrder
                    mockQueue.setCompleteOrder(null);
                } else {
                    // 完成其他业务操作
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
