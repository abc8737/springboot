package yerenpeng.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPool 线程池
 *
 * @Author: YeRenpeng
 * @e-mail: abc8737@163.com
 * @github: https://github.com/Liu-xingyu
 * @Date: 2018/11/27 21:41
 * @Version 1.0
 */
public class MyThreadPool {

    private static Logger logger = Logger.getLogger(MyThreadPool.class);
    private static String threadName;

    public static void main(String[] args) {
        // 初始化log4j
        BasicConfigurator.configure();
        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(5);
        // 抛弃存储时间最久的runnable
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();
        // 队列满了就不会再有runnable加入队列
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 10, 60, TimeUnit.SECONDS, blockingQueue, handler);
        for (int i = 1; i <= 16; i++) {
            threadName = "Thread-" + i;
            executor.execute(new Thread(new MyThread(), threadName));
            logger.info("线程池中活跃的线程数量：" + executor.getPoolSize() + ", " + threadName);

            if (blockingQueue.size() > 0) {
                logger.debug("阻塞队列中等待的线程数量:" + blockingQueue.size() + ", " + threadName);
            }
        }
        logger.error("==========================================================================");
        for (Runnable runnable : blockingQueue) {
//            runnable = new Thread(new MyThread());
            logger.warn(executor.getThreadFactory().newThread(runnable).getName());
            System.out.println();
        }

        executor.shutdown();

    }

}
