package spring.boot.com.concurrent;

/**
 * @author: yiqq
 * @date: 2019/7/11
 * @description:
 */
public class 实现Runnable接口 {

    public static void main(String[] args) {
        MyThread2 myThread=new MyThread2();
        Thread thread = new Thread(myThread);
        thread.start();
    }

    /*通过实现Runnable接口创建并启动线程一般步骤如下：
    1】定义Runnable接口的实现类，一样要重写run()方法，这个run（）方法和Thread中的run()方法一样是线程的执行体
    2】创建Runnable实现类的实例，并用这个实例作为Thread的target来创建Thread对象，这个Thread对象才是真正的线程对象
    3】第三部依然是通过调用线程对象的start()方法来启动线程*/

    static class MyThread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("我是实现Runnable接口！！ ");
        }
    }
}
