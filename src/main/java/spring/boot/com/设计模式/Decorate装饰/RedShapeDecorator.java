package spring.boot.com.设计模式.Decorate装饰;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description: 创建扩展自 ShapeDecorator 类的实体装饰类。
 */
public class RedShapeDecorator  extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }

}
