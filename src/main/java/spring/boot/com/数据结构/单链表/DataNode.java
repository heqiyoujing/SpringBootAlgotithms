package spring.boot.com.数据结构.单链表;

/**
 * @author: yiqq
 * @date: 2019/7/16
 * @description: java 单链表反转
 * https://www.cnblogs.com/zhou-test/p/10032063.html
 * https://www.cnblogs.com/zhengcj/p/7494089.html
 * https://www.cnblogs.com/xiongmozhou/p/10162711.html
 */
public class DataNode {

    public int data;
    public DataNode next;
    public DataNode(int data) {
        this.data = data;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public DataNode getNext() {
        return next;
    }
    public void setNext(DataNode next) {
        this.next = next;
    }

}
