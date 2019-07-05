package spring.boot.com.pattern.Strategy策略;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description: 策略是行为型模式,它的作用是让一个对象在许多行为中选择一种行为;
 *
 */
public class StrategyPatternTest {
    public static void main(String[] args) {

        /**
         *用途不一样
         工厂是创建型模式,它的作用就是创建对象；
         策略是行为型模式,它的作用是让一个对象在许多行为中选择一种行为;
         关注点不一样
         一个关注对象创建
         一个关注行为的封装

         解决不同的问题
         工厂模式是创建型的设计模式，它接受指令，创建出符合要求的实例；它主要解决的是资源的统一分发，将对象的创建完全独立出来，让对象的创建和具体的使用客户无关。主要应用在多数据库选择，类库文件加载等。
         策略模式是为了解决的是策略的切换与扩展，更简洁的说是定义策略族，分别封装起来，让他们之间可以相互替换，策略模式让策略的变化独立于使用策略的客户。

         工厂相当于黑盒子，策略相当于白盒子；
         *
         *工厂模式
         有一天你决定去吃培根披萨，首先得选择店铺，A店和B店都有培根披萨；
         你点了A店的培根披萨，过了二十分钟，你的披萨就来了就可以吃到了。但这个披萨是怎么做的，到底面粉放了多少，培根放了多少，佐料放了多少，有多少道工序，你是不需要管的，你需要的是一个美味培根披萨。

         策略模式
         在披萨店，你要一个培根披萨，老板说有标准的pizza，也可以自己去做。原料有培根、面粉、佐料。工序有1、2、3工序，你自己去做吧。然后你就需要自己去做，到底放多少培根，放多少面粉，放多少佐料，这都你自己来决定，工序1、2、3，你是怎么实现的，都你自己决定。最后你得到了披萨。
         *
         * */

        Context context;
        context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();

        context = new Context(new ConcreteStrategyC());
        context.contextInterface();
    }
}
