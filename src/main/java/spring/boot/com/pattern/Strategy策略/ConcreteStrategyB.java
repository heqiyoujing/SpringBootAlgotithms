package spring.boot.com.pattern.Strategy策略;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:
 */
public class ConcreteStrategyB  extends Strategy{
    /**
     * 算法B实现方法
     */
    @Override
    public void AlgorithmInterface() {
        System.out.println("算法B的实现");
    }
}
