package spring.boot.com.pattern.Decorate装饰;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description: 向一个现有的对象添加新的功能，同时又不改变其结构。使用场景： 1、扩展一个类的功能。 2、动态增加功能，动态撤销。
 * https://blog.csdn.net/L1fe1/article/details/82263522
 */
public class DecoratorPatternTest {
    public static void main(String[] args) {
        /**
         * 代理模式和装饰模式非常类似，甚至代码都类似。二者最主要的区别是：代理模式中，代理类对被代理的对象有控制权，
         * 决定其执行或者不执行。而装饰模式中，装饰类对代理对象没有控制权，只能为其增加一层装饰，以加强被装饰对象的功能，仅此而已。
         *
         */

        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
