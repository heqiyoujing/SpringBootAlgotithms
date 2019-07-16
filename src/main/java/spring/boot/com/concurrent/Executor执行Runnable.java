package spring.boot.com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yiqq
 * @date: 2019/7/11
 * @description:
 */
public class Executor执行Runnable {

    /**
     * 从结果中可以看出，pool-1-thread-1和pool-1-thread-2均被调用了两次，这是随机的，execute会首先在线程池中选择
     * 一个已有空闲线程来执行任务，如果线程池中没有空闲线程，它便会创建一个新的线程来执行任务。
     */
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
//      ExecutorService executorService = Executors.newFixedThreadPool(5);
//      ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++){
            executorService.execute(new TestRunnable());
            System.out.println("************* a" + i + " *************");
        }
        executorService.shutdown();
    }
}

     class TestRunnable implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + "线程被调用了。");
        }

}
