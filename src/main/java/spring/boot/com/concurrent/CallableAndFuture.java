package spring.boot.com.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: yiqq
 * @date: 2019/7/11
 * @description:
 */
public class CallableAndFuture {

    /*1】创建Callable接口的实现类，并实现call()方法，然后创建该实现类的实例（从java8开始可以直接使用Lambda表达式创建Callable对象）。
      2】使用FutureTask类来包装Callable对象，该FutureTask对象封装了Callable对象的call()方法的返回值
      3】使用FutureTask对象作为Thread对象的target创建并启动线程（因为FutureTask实现了Runnable接口）
      4】调用FutureTask对象的get()方法来获得子线程执行结束后的返回值*/
    public static void main(String[] args) {

       /* FutureTask<Integer> future=new FutureTask<Integer>(
                (Callable<Integer>)()->{
                    return 5;
                }
        );*/

        Callable<Integer> call = new Callable<Integer>() {
            public Integer call() throws Exception {
                System.out.println("计算线程正在计算结果...");
                Thread.sleep(3000);
                return 1;
            }
        };
        FutureTask<Integer> future = new FutureTask<>(call);

        new Thread(future,"有返回值的线程").start();//实质上还是以Callable对象来创建并启动线程

        try {
            System.out.println("子线程的返回值：" + future.get());//get()方法会阻塞，直到子线程执行结束才返回
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
