package spring.boot.com.数据结构.队列;

import java.util.Stack;

/**
 * @author: yiqq
 * @date: 2019/7/19
 * @description: 栈实现队列
 */
public class StackForQuene<T> {

    private Stack<T> mIn = null;
    private Stack<T> mOut = null;
    private int count = 0;

    public StackForQuene() {
        mIn = new Stack<T>();
        mOut = new Stack<T>();
        count = 0;
    }

    //对列增加元素
    public void add(T val) {
        while (!mOut.isEmpty()) {
            mIn.push(mOut.pop());
        }
        mIn.push(val);
        count++;
    }

    //获取队列元素
    public  T get() {
        while (!mIn.isEmpty()) {
            mOut.push(mIn.pop());
        }
        count--;
        return mOut.pop();
    }

    //队列大小
    public int size() {
        return count;
    }

    //队列是否为空
    public boolean isEmpty() {
        return size() == 0;
    }
}
