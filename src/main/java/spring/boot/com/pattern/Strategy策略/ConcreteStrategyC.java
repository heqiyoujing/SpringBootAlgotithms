package spring.boot.com.pattern.Strategy策略;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:
 */
public class ConcreteStrategyC  extends Strategy{
    @Override
    public void AlgorithmInterface() {
        System.out.println("算法C的实现");
    }
}
