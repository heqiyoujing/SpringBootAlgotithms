package spring.boot.com.设计模式.Decorate装饰;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:  创建实现了 Shape 接口的抽象装饰类。
 */
abstract  class ShapeDecorator implements Shape{
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }

}
