package spring.boot.com.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: yiqq
 * @date: 2019/7/11
 * @description:
 */
public class 自定义ThreadPool {

    /**
     * 从结果中可以看出，七个任务是在线程池的三个线程上执行的。这里简要说明下用到的ThreadPoolExecuror类的构造方法中各个参数的含义.
     * public ThreadPoolExecutor (int corePoolSize, int maximumPoolSize, long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue)
     * corePoolSize：线程池中所保存的线程数，包括空闲线程。
     * maximumPoolSize：池中允许的最大线程数。
     * keepAliveTime：当线程数大于核心数时，该参数为所有的任务终止前，多余的空闲线程等待新任务的最长时间。
     * unit：等待时间的单位。
     * workQueue：任务执行前保存任务的队列，仅保存由execute方法提交的Runnable任务。

     1、线程只是实现Runnable或实现Callable接口，还可以继承其他类。
     2、这种方式下，多个线程可以共享一个target对象，非常适合多线程处理同一份资源的情形。
     3、但是编程稍微复杂，如果需要访问当前线程，必须调用Thread.currentThread()方法。
     4、继承Thread类的线程类不能再继承其他父类（Java单继承决定）。
     5、前三种的线程如果创建关闭频繁会消耗系统资源影响性能，而使用线程池可以不用线程的时候放回线程池，用的时候再从线程池取，项目开发中主要使用线程池
     */

    public static void main(String[] args){
        //创建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
        //创建线程池，池中保存的线程数为3，允许的最大线程数为5
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,50, TimeUnit.MILLISECONDS,bqueue);
        //创建七个任务
        Runnable t1 = new MyThread();
        Runnable t2 = new MyThread();
        Runnable t3 = new MyThread();
        Runnable t4 = new MyThread();
        Runnable t5 = new MyThread();
        Runnable t6 = new MyThread();
        Runnable t7 = new MyThread();
        //每个任务会在一个线程上执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t7);
        //关闭线程池
        pool.shutdown();
    }

    static class MyThread implements Runnable{
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName() + "正在执行。。。");
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
