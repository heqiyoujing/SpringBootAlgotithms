package spring.boot.com.数据结构.队列;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;

/**
 * @author: yiqq
 * @date: 2019/7/19
 * @description:
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
//        ArrayQueue<String> arrayQueue = new ArrayQueue<>(String.class, 10);
//        arrayQueue.add("我");
//        arrayQueue.add("是");
//        arrayQueue.add("程序员");
//        arrayQueue.add("！");
//        System.out.println("返回队列开头元素："+arrayQueue.front());
//        System.out.println("返回队列栈顶元素："+arrayQueue.pop());
//        System.out.println("返回队列大小：" + arrayQueue.size());
//
//
//        StackForQuene stackForQuene = new StackForQuene();
//        stackForQuene.add("我");
//        stackForQuene.add("是");
//        stackForQuene.add("程序员");
//        stackForQuene.add("!");
//        System.out.println("返回队列栈顶元素："+stackForQuene.get());
//        System.out.println("返回队列大小：" + stackForQuene.size());

        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("poll="+queue.poll()); //返回第一个元素，并在队列中删除
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("element="+queue.element()); //返回第一个元素
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("peek="+queue.peek()); //返回第一个元素
        for(String q : queue){
            System.out.println(q);
        }
    }
}
