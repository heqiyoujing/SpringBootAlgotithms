package spring.boot.com.pattern.Decorate装饰;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:
 */
public class Rectangle  implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle...");
    }
}
