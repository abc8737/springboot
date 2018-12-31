package yerenpeng.test;

/**
 * @Author: YeRenpeng
 * @e-mail: abc8737@163.com
 * @github: https://github.com/Liu-xingyu
 * @Date: 2018/11/27 21:38
 * @Version 1.0
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        try {
            // threadLocal创建本地副本，新的变量或者对象创建新的副本，创建一个副本数字num就increment 1
            System.err.println(new Thread(new MyThread()).getName() + "," + MyThreadLocal.get());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
