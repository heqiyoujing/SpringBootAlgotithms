package spring.boot.com.pattern.Builder建造者;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:
 * https://www.cnblogs.com/liaoweipeng/p/5790603.html
 */
public class BuilderPatternTest {
    public static void main(String[] args) {
        /**
         * 工厂方法模式和建造者模式都属于对象创建类模式，都用来创建类的对象。但它们之间的区别还是比较明显的。
         　　● 意图不同
         　　在工厂方法模式里，我们关注的是一个产品整体，如超人整体，无须关心产品的各部分是如何创建出来的；但在建造者模式中，
         一个具体产品的产生是依赖各个部件的产生以及装配顺序，它关注的是“由零件一步一步地组装出产品对象”。简单地说，工厂模
         式是一个对象创建的粗线条应用，建造者模式则是通过细线条勾勒出一个复杂对象，关注的是产品组成部分的创建过程。
         　　● 产品的复杂度不同
         　　工厂方法模式创建的产品一般都是单一性质产品，如成年超人，都是一个模样，而建造者模式创建的则是一个复合产品，它由
         各个部件复合而成，部件不同产品对象当然不同。这不是说工厂方法模式创建的对象简单，而是指它们的粒度大小不同。一般来说，
         工厂方法模式的对象粒度比较粗，建造者模式的产品对象粒度比较细。
         　　两者的区别有了，那在具体的应用中，我们该如何选择呢？是用工厂方法模式来创建对象，还是用建造者模式来创建对象，
         这完全取决于我们在做系统设计时的意图，如果需要详细关注一个产品部件的生产、安装步骤，则选择建造者，否则选择工厂方法模式。
         *
         * */


        Director director = new Director();
        Builder builder = new ConcreteBuilder();
        director.Construct(builder);
        Computer computer = builder.getComputer();
        computer.print();
    }
}
