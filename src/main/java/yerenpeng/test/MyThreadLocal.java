package yerenpeng.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Test ThreadLocal
 *
 * @Author: YeRenpeng
 * @e-mail: abc8737@163.com
 * @github: https://github.com/Liu-xingyu
 * @Date: 2018/11/30 21:33
 * @Version 1.0
 */
public class MyThreadLocal {

    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static int get() {
        return threadId.get();
    }

}
