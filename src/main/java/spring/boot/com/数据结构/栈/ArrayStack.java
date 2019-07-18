package spring.boot.com.数据结构.栈;

import java.lang.reflect.Array;

/**
 * @author: yiqq
 * @date: 2019/7/18
 * @description: 栈
 */
public class ArrayStack<T> {
    private static final int DEFAULT_SIZE = 12;
    private T[] mArray;
    private int count;

    public ArrayStack(Class<T> type) {
        this(type, DEFAULT_SIZE);
    }

    public ArrayStack(Class<T> type, int size) {
//        Object array = Array.newInstance(type, 10);//创建一个长度为10的字符串数组，在Java中数组也可以作为Object对象
        mArray = (T[]) Array.newInstance(type, size);//创建数组
        count = 0;
    }

    //入栈
    public void push(T val) {
        mArray[count++] = val;
    }
    //出栈
    public T pop (){
        T ret = mArray[count - 1];
        count--;
        return ret;
    }
    //栈顶元素
    public T peek(){
        return mArray[count - 1];
    }
    //栈大小
    public int size(){
        return count;
    }
    //栈是否为空
    public boolean isEmpty(){
        return count == 0;
    }
    //打印栈元素
    public void print(){
        if (isEmpty()) {
            System.out.printf("stack is Empty\n");
        }

        int i = size() - 1;
        while (i >= 0) {
            System.out.println(mArray[i]);
            i--;
        }
    }

}
