package spring.boot.com.数据结构.栈;

/**
 * @author: yiqq
 * @date: 2019/7/18
 * @description:
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<String> arrayStack = new ArrayStack<>(String.class);
        arrayStack.push("！");
        arrayStack.push("程序猿");
        arrayStack.push("是");
        arrayStack.push("我");

        arrayStack.print();

        System.out.println("出栈元素：" + arrayStack.pop());

        System.out.println("返回栈顶元素：" + arrayStack.peek());


    }
}
