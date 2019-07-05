package spring.boot.com.pattern.Decorate装饰;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:
 */
public class Circle  implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape: Circle...");
    }
}
