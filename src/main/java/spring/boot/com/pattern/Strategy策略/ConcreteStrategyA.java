package spring.boot.com.pattern.Strategy策略;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:
 */
public class ConcreteStrategyA  extends Strategy{
    //算法A实现方法
    @Override
    public void AlgorithmInterface() {
        System.out.println("算法A的实现");
    }
}
