package spring.boot.com.concurrent;

/**
 * @author: yiqq
 * @date: 2019/7/11
 * @description:
 */
public class 继承Thread类 {

    public static void main(String[] args) {
        new MyThread().start();
    }
    /*通过继承Thread类来创建并启动多线程的一般步骤如下
    1】d定义Thread类的子类，并重写该类的run()方法，该方法的方法体就是线程需要完成的任务，run()方法也称为线程执行体。
    2】创建Thread子类的实例，也就是创建了线程对象
    3】启动线程，即调用线程的start()方法*/

   static class MyThread extends Thread {//继承Thread
        public void run() {
            System.out.println("我是继承Thread类！！ ");
        }
    }

}
