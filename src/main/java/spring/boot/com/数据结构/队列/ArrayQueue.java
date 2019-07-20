package spring.boot.com.数据结构.队列;

import java.lang.reflect.Array;

/**
 * @author: yiqq
 * @date: 2019/7/19
 * @description:
 */
public class ArrayQueue<T> {
    private T[] mArry;
    private int count;

    public ArrayQueue(Class<T> type, int sz) {
        mArry = (T[]) Array.newInstance(type, sz);
        count = 0;
    }

    //队列增加元素
    public void add(T val) {
        mArry[count++] = val;
    }

    //队列返回开头元素
    public T front() {
        return mArry[0];
    }

    //返回栈顶元素
    public T pop() {
        T rer = mArry[0];
        count--;
        for(int i=1;i<count;i++) {
            mArry[i - 1] = mArry[i];
        }
        return rer;
    }
    //返回队列大小
    public int size(){
        return count;
    }
    // 返回“栈”是否为空
    public boolean isEmpty() {
        return size()==0;
    }


}
