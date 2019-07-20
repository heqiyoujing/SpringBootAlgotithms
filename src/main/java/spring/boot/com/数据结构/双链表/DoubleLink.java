package spring.boot.com.数据结构.双链表;

/**
 * @author: yiqq
 * @date: 2019/7/20
 * @description: 双链表
 * https://www.cnblogs.com/skywang12345/p/3561803.html#a33
 */
public class DoubleLink<T> {
    //表头
    private Node<T> head;

    //节点个数
    private int count;

    // 双向链表“节点”对应的结构体
    private class Node<T> {
        public Node pre;
        public Node next;
        public T value;

        public Node(T value, Node pre, Node next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    //构造函数
    public DoubleLink() {
        //表头不存数据
        head = new Node<T>(null, null, null);
        head.pre = head.next = head;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    /**获取第index位置的节点*/
    private Node<T> getNode(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        //正向查找
        if (index <= count / 2) {
            Node<T> node = head.next;
            for(int i=0;i<index;i++) {
                node = node.next;
            }
            return node;
        }else {
            Node<T> node = head.pre;
            int rindex = count - index - 1;
            for(int i=0;i<rindex;i++) {
                node = node.pre;
            }
            return node;
        }
    }

    // 获取第index位置的节点的值
    public T get(int index) {
        return getNode(index).value;
    }

    //获取第一个节点的值
    public T geFirst(){
        return getNode(0).value;
    }

    //获取最后一个节点的值
    public T getLast() {
        return getNode(count - 1).value;
    }

    /**将节点插入到第index的位置之前*/
    public void insert(int index, T t) {
        if (index == 0) {
            Node<T> node = new Node<>(t, head, head.next);
            head.next.pre = node;
            head.next = node;
            count++;
        }else {
            Node<T> node = getNode(index);
            Node<T> tNode = new Node<>(t, node.pre, node);
            node.pre.next = tNode;
            node.next = tNode;
            count++;
        }
    }

    //将节点插入第一个节点处
    public void insertFirst(T t) {
        insert(0, t);
    }

    //将节点添加到链表结尾
    public void appendLast(T t){
        Node<T> node = new Node<>(t, head.pre, head);
        head.pre.next = node;
        head.pre = node;
        count++;
    }

    /**删除节点位置*/
    public void del(int index) {
        Node<T> node = getNode(index);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node = null;
        count--;
    }

    // 删除第一个节点
    public void deleteFirst(){
        del(0);
    }
    //// 删除第一个节点
    public void deleteLast(){
        del(count - 1);
    }
}
